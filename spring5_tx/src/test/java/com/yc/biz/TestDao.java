package com.yc.biz;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yc.bean.Accounts;
import com.yc.dao.AccountsDao;
import com.yc.tx.AppConfig;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestDao {
    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier(value = "accountsDaoImpl")
    private AccountsDao accountsDao;

    @Test
    public void testdao() throws SQLException {
        Assert.assertNotNull(dataSource);
        System.out.println(dataSource.getConnection());
    }


    @Test
    public void testAccountsDaoImpl(){
        Assert.assertNotNull(accountsDao);
    }

    @Test
    public void testopenaccounts(){
        Accounts a =new Accounts();
        a.setBalance(10d);
        int id = accountsDao.saveAccounts(a);
        System.out.println("开户成功，新开户头id为："+id);
    }

    @Test
    public void testfindallAccount(){
        List<Accounts> all = accountsDao.findAll();
        System.out.println(all);
    }

    @Test
    public void testdeleteAccount(){
        System.out.println(accountsDao.deleteAccounts(2)==1);
    }

    @Test
    public void testFindOne(){
        System.out.println(accountsDao.findAccount(1));
    }
}
