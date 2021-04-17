package com.yc.dao;

import com.yc.bean.Oprecord;

import java.util.List;

public interface OprecordDao {
    public int saveOprecord(Oprecord oprecord);//记录表所有的方法

    public List<Oprecord> findByAccountid(int accountid);


    public List<Oprecord> findAll();

}
