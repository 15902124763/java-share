package com.yarm.controller;

import com.yarm.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRedisController {
    @Autowired
    RedisService redisService;
    @GetMapping("redis/mq/push")
    public String push(String value){
        redisService.push("my_list", value);
//        return redisService.rpop("my_list");
        return "ok";
    }

    @GetMapping("redis/mq/pop")
    public String pop(){
        return "ok";
    }
}
