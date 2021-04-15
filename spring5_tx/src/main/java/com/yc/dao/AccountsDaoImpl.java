package com.yc.dao;

import com.yc.bean.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class AccountsDaoImpl implements AccountsDao {
    @Resource
    public DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate((dataSource));
    }


    @Override
    public int saveAccounts(Accounts accounts) {
        final String sql = "insert into accounts(balance) values(?)";
        //通常情况下我们在程序中往数据库插入记录，如果主键id是由数据库负责生成，
        // 在插入成功之后都是返回主键id方便在插入其它数据时做主键关联，
        // spring Jdbctemplate对这个也是支持的，
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            //columnNames 一个列名数组，它指示应该从插入的行返回的列
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"accountid"});
            //第二个参数的意思是返回这个字段生成的键
            ps.setDouble(1, accounts.getBalance());
            return ps;
        }, keyHolder);
        Number key = keyHolder.getKey();
        return key.intValue();
    }

    @Override
    public int updateAccounts(Accounts accounts) {
        final String UPDATE_SQL = "update accounts set balance = ? where accountid =?";
        int update = this.jdbcTemplate.update(UPDATE_SQL, accounts.getBalance(), accounts.getAccountId());
        return update;
    }

    @Override
    public int deleteAccounts(int accountId) {
        final String DELETE_SQL = "delete from accounts where accountid=?";
        int update = this.jdbcTemplate.update(DELETE_SQL, accountId);
        return update;
    }

    @Override
    public List<Accounts> findAll() {
        final String SELECT_SQL = "select * from accounts ";
        List<Accounts> list = this.jdbcTemplate.query(SELECT_SQL, (resultset, rowNum) -> {
            Accounts accounts = new Accounts();
            accounts.setBalance(resultset.getDouble("balance"));
            accounts.setAccountId(resultset.getInt("accountid"));
            return  accounts;
        });
        return list;
    }

    @Override
    public Accounts findAccount(int accountId) {
        final String SELECT_SQL = "select * from accounts where accountId =?";
        Accounts accounts = new Accounts();
        this.jdbcTemplate.queryForObject(SELECT_SQL, (resultset, rownum) -> {
            accounts.setAccountId(resultset.getInt("accountid"));
            accounts.setBalance(resultset.getDouble("balance"));
            return accounts;
        }, accountId);
        return accounts;
    }
}
