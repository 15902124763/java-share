package com.niki.account.dao;

import com.niki.account.po.SkyCbhsjkbPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/25
 */
@Repository
public class Ds1Dao {
    @Autowired
    @Qualifier("ds1JdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public void test(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM t_dam_info");
    }

    public boolean insert(SkyCbhsjkbPo po){
        String sql = "INSERT INTO `jepaas`.`sidri_sky_cbhsjkb`(`PREPAREDDATE`, `YEAR`, `PERIOD`, `DEBITAMOUNT`, `VALUECODE`, `SUBJCODE`, `SUBJNAME`, `explanation`, `create_user`, `create_date`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return  jdbcTemplate.update(sql,po.getPreparedDate(), po.getYear(), po.getPeriod(), po.getDebitAmount(), po.getValueCode(), po.getSubjCode(),po.getSubjName(),po.getExplanation(),po.getCreateUser(), new Date()) > 0;
    }
}
