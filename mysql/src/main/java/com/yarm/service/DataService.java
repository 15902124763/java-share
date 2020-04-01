package com.yarm.service;

import com.yarm.pojo.Goods;
import com.yarm.response.Result;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface DataService {
    Result<Long> insert() throws ExecutionException, InterruptedException;
    int run(List<List<Goods>> listList) throws ExecutionException, InterruptedException;
    int threadGroup() throws ExecutionException, InterruptedException;
    int fetchInsert(List<Goods> goodsList);
}
