package com.niki.account.dao;

import com.niki.account.po.SkyCbhsjkbPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/25
 */
@Repository
public class Ds2Dao {
    @Autowired
    @Qualifier("ds2JdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<SkyCbhsjkbPo> queryByCode(String code){
        List<SkyCbhsjkbPo> query = jdbcTemplate.query("select * from SKY_CBHSJKB WHERE VALUECODE=?", new BeanPropertyRowMapper<SkyCbhsjkbPo>(SkyCbhsjkbPo.class), code);
        System.out.println(query);
        return query;
    }
}
