package com.yarm.controller;

import com.yarm.pojo.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {

    @RequestMapping("getFile")
    public String getFile() throws IOException {
        File file = new File("");
        FileReader fileReader = new FileReader("D:\\download\\item_desc_dataset.txt");
        List<Product> list = new ArrayList<>();
        try {
            // 结果集
            int count = 0;
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String[] arr = line.split("\t");
                Product product = new Product();
                product.setName(arr[0]);
                product.setDesc(arr[1]);
                list.add(product);
                count ++;
            }
            System.out.println(count);
            System.out.println(list.size());
            bufferedReader.close();
        }catch (IOException e){

        }finally {
            fileReader.close();
        }
        return "ok";
    }
}
