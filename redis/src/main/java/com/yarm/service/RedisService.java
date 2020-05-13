package com.yarm.service;

import com.yarm.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    RedisUtil redisUtil;

    public void push(String key, String value){
        redisUtil.lpush(key, value);
    }

    public String rpop(String key){
        String rpop = redisUtil.rpop(key);
        return rpop;
    }
}
