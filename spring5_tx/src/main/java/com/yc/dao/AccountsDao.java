package com.yc.dao;

import com.yc.bean.Accounts;

import java.util.List;

public interface AccountsDao {
    public int saveAccounts(Accounts accounts);

    public int updateAccounts(Accounts accounts);

    public int deleteAccounts(int accountsid);

    public List<Accounts> findAll();

    public Accounts findAccount(int accountsId);
}
