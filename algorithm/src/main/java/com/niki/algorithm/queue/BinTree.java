package com.niki.algorithm.queue;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/5
 */

import lombok.Data;

/**
 * @Description :二叉树定义
 * @Author : yarm.yang
 * @Date : 2020/11/5 16:20
*/
@Data
public class BinTree<T> {
    // 数据域
    private T data;
    private BinTree left;
    private BinTree right;
    private BinTree root;
}

class SortBinTree{
    // 先序
}
