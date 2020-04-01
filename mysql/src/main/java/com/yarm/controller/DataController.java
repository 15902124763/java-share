package com.yarm.controller;

import com.yarm.response.Result;
import com.yarm.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;


@RestController
public class DataController {

    @Autowired
    DataService dataService;

    @RequestMapping("insert")
    public Result insert() throws ExecutionException, InterruptedException {
        Result<Long> insert = dataService.insert();
        return insert;
    }
}
