package com.niki.account.po;

import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/25
 * @author niki.yang
 */
@Data
public class SkyCbhsjkbPo {
    private Long id;
    private String preparedDate;
    private String year;
    private String period;
    private String debitAmount;
    private String valueCode;
    private String subjCode;
    private String subjName;
    private String explanation;
    private String createUser;
    private Date createDate;
}
