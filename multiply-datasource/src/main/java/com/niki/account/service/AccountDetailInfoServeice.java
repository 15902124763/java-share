package com.niki.account.service;


import com.niki.account.po.SkyCbhsjkbPo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/25
 */
public interface AccountDetailInfoServeice {
    List<SkyCbhsjkbPo> getByCode(String code);
    boolean insert(SkyCbhsjkbPo po);

    boolean bachInsert(String code);
}
