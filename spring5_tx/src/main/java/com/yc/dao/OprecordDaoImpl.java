package com.yc.dao;

import com.yc.bean.Oprecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;
import javax.management.Query;
import javax.sql.DataSource;

@Repository
public class OprecordDaoImpl implements OprecordDao {
    @Resource
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int saveOprecord(Oprecord oprecord) {
        final String INSERT_SQL = "insert into oprecord(accountid,opmoney,optime,optype,transferid) values(?,?,?,?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update( con->{
            PreparedStatement ps=con.prepareStatement(INSERT_SQL,new String[]{"id"});
            ps.setInt(1,oprecord.getAccountid());
            ps.setDouble(2,oprecord.getOpomoney());
            ps.setObject(3,oprecord.getOptime());
            ps.setString(4,oprecord.getOptype());
            ps.setString(5,oprecord.getTransferid());
            return  ps;
        },keyHolder);
        Number key=keyHolder.getKey();
        return key.intValue();
    }

    @Override
    public List<Oprecord> findByAccountid(int accountid) {
        final String SELECT_SQL ="select * from oprecord where accountid =?";
        List<Oprecord> query = this.jdbcTemplate.query(SELECT_SQL, (resultset, rowNum) -> {
            Oprecord oprecord = new Oprecord();
            oprecord.setId(resultset.getInt("id"));
            oprecord.setAccountid(resultset.getInt("accountid"));
            oprecord.setOpomoney(resultset.getDouble("opmoney"));
            Timestamp optime = (Timestamp) resultset.getObject("optime");
            oprecord.setOptime(optime);
            oprecord.setTransferid(resultset.getString("transferid"));
            return oprecord;
        },accountid);
        return query;
    }

    @Override
    public List<Oprecord> findAll() {
       final String SELECT_SQL="select * from oprecord";
       List<Oprecord> list =jdbcTemplate.query(SELECT_SQL,(resultset,rowNum)->{
          Oprecord oprecord =new Oprecord();
           oprecord.setId(resultset.getInt("id"));
           oprecord.setAccountid(resultset.getInt("accountid"));
           oprecord.setOpomoney(resultset.getDouble("opmoney"));
           oprecord.setOptime((Timestamp) resultset.getObject("optime"));
           oprecord.setTransferid(resultset.getString("transferid"));
           return oprecord;
       });
       return list;
    }


}
