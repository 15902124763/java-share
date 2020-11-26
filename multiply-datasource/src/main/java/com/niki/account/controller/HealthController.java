package com.niki.account.controller;

import com.niki.account.service.AccountDetailInfoServeice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/25
 */
@RestController
public class HealthController {

    @Value("${spring.application.name:account-default}")
    private String appName;

    @Autowired
    private AccountDetailInfoServeice accountDetailInfoServeice;

    @RequestMapping("/")
    public String index() {

        return "it work";
    }

    @RequestMapping("test")
    public String test(){
        accountDetailInfoServeice.bachInsert("2013JZ(1)-005");
        return "ok";
    }
}
