package com.yc.biz;

import com.yc.bean.OpTypes;
import com.yc.bean.Oprecord;
import com.yc.dao.OprecordDao;
import com.yc.tx.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestOprecordDao {

    @Resource
    OprecordDao oprecordDao;

    @Test
    public void testSave() {
        Oprecord oprecord=new Oprecord();
        oprecord.setAccountid(1);
        oprecord.setOpomoney(1.0);
        //通过枚举来约束不容易错
        oprecord.setOptype(OpTypes.deposite.getName());
        oprecord.setOptime(new Timestamp(new Date().getTime()));
        oprecord.setTransferid(" ");//简单存钱没有 transferid
        oprecordDao.saveOprecord(oprecord);
    }

    @Test
    public void testFindAll() {
        List<Oprecord>list=oprecordDao.findAll();
        //数据库里已有记录，断言数据库记录不为0
        Assert.assertNotEquals(0,list.size());

//        System.out.println(oprecordDao.findAll());
    }

    @Test
    public void testFindById() {
        List<Oprecord>list=oprecordDao.findByAccountid(1);
        Assert.assertNotEquals(0,list.size());
//        System.out.println(oprecordDao.findByAccountid(1));
    }

    @Test
    public void testupdate() {
        Oprecord oprecord = new Oprecord(null, 1, 10d, new Timestamp(System.currentTimeMillis()), "deposite",
                UUID.randomUUID().toString());

        System.out.println(oprecordDao.saveOprecord(oprecord));

    }

}
