package com.yc.service;

import com.yc.bean.Accounts;
import com.yc.bean.OpTypes;
import com.yc.bean.Oprecord;
import com.yc.dao.AccountsDao;
import com.yc.dao.OprecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Description TODO
 * @Author mizuhokaga
 * @Date 2021-04-17 16:43
 */
@Service
//基本都是默认配置，为了演示。不写也没关系
@Transactional(
        propagation = Propagation.REQUIRED,//传播机制
        isolation = Isolation.DEFAULT,
        readOnly = false,
        timeout = 100,
        rollbackForClassName = {"RuntimeException"})
public class AccountsServiceImpl implements AccountSerivce {
    @Autowired
    AccountsDao accountsDao;
    @Autowired
    OprecordDao oprecordDao;

    @Override
    //开户流程：先存钱返回accoutid，然后生成对应的流水表
    public Integer openAccount(Accounts account, double money) {
        account.setBalance(money);
        int accountid=accountsDao.saveAccounts(account);

        Oprecord oprecord=new Oprecord();
        oprecord.setAccountid(1);
        oprecord.setOpmoney(1.0);
        oprecord.setOptype(OpTypes.deposite.getName());
        oprecord.setOptime(new Timestamp(System.currentTimeMillis()));
        oprecord.setTransferid(" ");
        oprecordDao.saveOprecord(oprecord);
        return accountid;
    }

    @Override
    public Accounts deposite(Accounts account, double money,String optype,String transferid) {
       Accounts a =this.showBalance(account);

       Oprecord oprecord =new Oprecord();
       oprecord.setOpmoney(money);
       oprecord.setOptime(new Timestamp(System.currentTimeMillis()));
       oprecord.setOptype(optype);
       if(transferid == null)
       {
           oprecord.setTransferid(" ");
       }else {
           oprecord.setTransferid(transferid);
       }
       oprecordDao.saveOprecord(oprecord);

       a.setBalance(a.getBalance()+money);
       accountsDao.updateAccounts(a);
       return  a;
    }

    @Override
    public Accounts withdraw(Accounts account, double money,String optype,String transferid) {
      Accounts a=this.showBalance(account) ;

      Oprecord oprecord=new Oprecord();
      oprecord.setAccountid(a.getAccountId());
      oprecord.setOptime(new Timestamp(System.currentTimeMillis()));
      oprecord.setOptype(optype);
      oprecord.setOpmoney(money);
        if(transferid == null)
        {
            oprecord.setTransferid(" ");
        }else {
            oprecord.setTransferid(transferid);
        }
        oprecordDao.saveOprecord(oprecord);

        a.setBalance(a.getBalance()-money);
        accountsDao.updateAccounts(a);
        return  a;
    }

    @Override
    public Accounts transfer(Accounts in, Accounts out, double money) {
      String uuid= UUID.randomUUID().toString();
      Accounts aa=this.deposite(in,money, OpTypes.transfer.getName(),uuid);
      return aa;
    }

    @Override
    @Transactional(readOnly = true)
    public Accounts showBalance(Accounts account) {
        return accountsDao.findAccount(account.getAccountId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Oprecord> findById(Accounts account) {
        return oprecordDao.findByAccountid(account.getAccountId());
    }
}
