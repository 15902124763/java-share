package com.niki.account.service.impl;


import com.niki.account.dao.Ds1Dao;
import com.niki.account.dao.Ds2Dao;
import com.niki.account.po.SkyCbhsjkbPo;
import com.niki.account.service.AccountDetailInfoServeice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/25
 */
@Service
public class AccountDetailInfoServeiceImpl implements AccountDetailInfoServeice {

    @Autowired
    Ds1Dao ds1Dao;

    @Autowired
    Ds2Dao ds2Dao;

    @Override
    public List<SkyCbhsjkbPo> getByCode(String code) {
        List<SkyCbhsjkbPo> list = ds2Dao.queryByCode("2013JZ(1)-005");
        return list;
    }

    @Override
    public boolean insert(SkyCbhsjkbPo po) {
        ds1Dao.insert(po);
        return false;
    }

    @Override
    public boolean bachInsert(String code) {
        List<SkyCbhsjkbPo> list = this.getByCode(code);
        list.forEach(v ->{
            ds1Dao.insert(v);
        });
        return true;
    }
}
