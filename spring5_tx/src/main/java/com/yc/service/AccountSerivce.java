package com.yc.service;

import com.yc.bean.Accounts;
import com.yc.bean.Oprecord;

import java.util.List;

/**
 * @Description 账户的事务接口
 * @Author mizuhokaga
 * @Date 2021-04-17 16:39
 */
public interface AccountSerivce {

    //开户
    public Integer openAccount(Accounts account, double money);

    //存
    public Accounts deposite(Accounts account ,double money,String optype,String transferid);

    //取
    public Accounts withdraw(Accounts account,double money,String optype,String transferid);
    //转账
    public Accounts transfer(Accounts in,Accounts out , double money);

    public Accounts showBalance(Accounts account);

    public List<Oprecord> findById(Accounts account);
}
