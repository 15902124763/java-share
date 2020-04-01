package com.yarm.service.impl;

import com.yarm.mapper.GoodsMapper;
import com.yarm.pojo.Goods;
import com.yarm.response.Result;
import com.yarm.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

@Service
public class DatServiceImpl implements DataService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    TransactionDefinition transactionDefinition;

    @Override
    public Result<Long> insert() throws ExecutionException, InterruptedException {
        Result<Long> result = new Result<>();
        long begin = System.currentTimeMillis();
        int i = threadGroup();
        long end = System.currentTimeMillis();
        long l = (end - begin) / 1000;
        result.setData(l);
        return result;
    }

    @Override
    public int run(List<List<Goods>> listList) throws ExecutionException, InterruptedException {
        // 创建一个线程池
        ExecutorService executorService = new ThreadPoolExecutor(
                10, 50,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
        // 启动几个线程
        for (List<Goods> list : listList){
            Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int count = fetchInsert(list);
                    return count;
                }
            };
            Future<Integer> submit = executorService.submit(task);
            futureList.add(submit);
        }

        // 线程返回
        int count = 0;
        for (int i = 0; i < futureList.size(); i++){
            Integer integer = futureList.get(i).get();
            if(integer != null){
                count += integer;
            }
        }

        // 关闭线程池
        executorService.shutdown();
        return count;
    }

    @Override
    public int threadGroup() throws ExecutionException, InterruptedException {
        int count = 0;
        Map<Integer, List<List<Goods>>> data = getData();
        for(Map.Entry<Integer, List<List<Goods>>> entry : data.entrySet()){
            List<List<Goods>> value = entry.getValue();
            long begin = System.currentTimeMillis();
            int run = run(value);
            long end = System.currentTimeMillis();
            System.out.println("每条执行:" + (end - begin)/run + "ms");
            count += run;
        }
        return count;
    }

//    @Transactional(rollbackFor = Exception.class)
    @Override
    public int fetchInsert(List<Goods> goodsList) {
        int count = 0;
        for (Goods goods : goodsList){
            count ++;
            goodsMapper.insert(goods);
        }
        return count;
    }

    private Map<Integer, List<List<Goods>>> getData(){
        List<Goods> list = new ArrayList<>();
        File file = new File("D:\\download\\item_desc_dataset.txt");
//        File file = new File("D:\\download\\test.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String[] arr = line.split("\t");
                Goods goods = new Goods();
                goods.setName(arr[0]);
                goods.setGoodsDesc(arr[1]);
                list.add(goods);
            }
        } catch (IOException e) {
            // ignore
        }
        // 每个线程处理条数
        List<List<Goods>> toList = toList(list, 2);
        Map<Integer, List<List<Goods>>> map = toMap(toList, 50);
        return map;
    }

    private static List<List<Goods>> toList(List<Goods> list, int pageSize){
        List<List<Goods>> result = new ArrayList<>();

        int start = 0;
        int page = 1;
        int size = list.size();
        if(pageSize > size){
            result.add(list);
            return result;
        }
        int totalPage = (int) Math.ceil(size / pageSize + 1);
        while (true){
            List<Goods> temp = list.subList(start, start + pageSize);
            result.add(temp);
            page ++;
            if(page == totalPage){
                List<Goods> end = list.subList(size - size % pageSize, size);
                if(end.size() != 0){
                    result.add(end);
                }
                return result;
            }
            start += pageSize;
        }
    }

    private static Map<Integer, List<List<Goods>>> toMap(List<List<Goods>> list, int pageSize){
        Map<Integer, List<List<Goods>>> result = new HashMap<>();
        int start = 0;
        int page = 1;
        int size = list.size();
        int totalPage = (int) Math.ceil(size / pageSize + 1);
        while (true){
            List<List<Goods>> temp = list.subList(start, start + pageSize);
            result.put(page,temp);
            page ++;
            if(page == totalPage){
                List<List<Goods>> end = list.subList(size - size % pageSize, size);
                if(end.size() != 0){
                    result.put(page, end);
                }
                return result;
            }
            start += pageSize;
        }
    }


    private static Map<Integer, List<String>> pageList(List<String> list, int pageSize){
        Map<Integer, List<String>> map = new HashMap<>();
        int start = 0;
        int page = 1;
        int size = list.size();
        int totalPage = (int) Math.ceil(size / pageSize + 1);
        while (true){
            List<String> temp = list.subList(start, start + pageSize);
            map.put(page, temp);
            page ++;
            start += pageSize;
            // 最后一页
            if(page == totalPage){
                List<String> end = list.subList(size - size % pageSize, size);
                if(end.size() != 0){
                    map.put(page, end);
                }
                return map;
            }
        }
    }
}
