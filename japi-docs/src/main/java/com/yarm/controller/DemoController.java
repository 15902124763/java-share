package com.yarm.controller;

import com.yarm.pojo.Result;
import com.yarm.pojo.User;
import com.yarm.pojo.UserVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("demo/user")
public class DemoController {
    /**
     * 新增用户
     * @param user
     * @Author : yarm.yang
     * @Date : 2020/6/23 9:53
    */
    @PostMapping("add")
    public Result<UserVo> add(@RequestBody User user){
        Result<UserVo> result = new Result<>();
        return result;
    }

    /**
     * 查询用户列表
     * @param uid 用户id
     * @param name 用户名
     * @Author : yarm.yang
     * @Date : 2020/6/23 9:53
     */
    @GetMapping("query")
    public Result<List<UserVo>> query(Long uid, String name){
        Result<List<UserVo>> result = new Result<>();
        return result;
    }
}
