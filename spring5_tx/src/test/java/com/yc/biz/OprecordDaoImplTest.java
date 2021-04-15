package com.yc.biz;

import com.yc.bean.Oprecord;
import com.yc.dao.OprecordDao;
import com.yc.tx.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class OprecordDaoImplTest {

    @Resource
    OprecordDao oprecordDao;


    @Test
    public void testfindall(){
        System.out.println(oprecordDao.findAll());
    }

    @Test
    public void testfindById(){
        System.out.println(oprecordDao.findByAccountid(1));
    }

    @Test
    public void testupdate(){
        Oprecord oprecord =new Oprecord(null,1,10d,new Timestamp(System.currentTimeMillis()),"deposite",
                UUID.randomUUID().toString());

        System.out.println(oprecordDao.saveOprecord(oprecord));

    }

}
