package com.niki.algorithm.queue;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/6
 */
@Data
public class HufNode<T> implements Comparable<HufNode<T>> {
    private T data;         //节点数据
    private int weight;     //权重
    private HufNode<T> left;   //左孩子
    private HufNode<T> right;  //右孩子


    @Override
    public int compareTo(HufNode<T> o) {
        if (o.weight > this.weight){
            return 1;
        }else if (o.weight < this.weight){
            return -1;
        }
        return 0;
    }
}

class HufTree{
    public static <T> HufNode<T> createTree(List<HufNode<T>> nodes) {   //参数是多个节点组成的队列
        while (nodes.size() > 1) {       //只剩一个节点是，退出循环
            Collections.sort(nodes);     //使用sort方法对nodes进行排序,CompareTo方法实现的是降序排列
            HufNode<T> left = nodes.get(nodes.size() - 1);  //取两个最小的节点
            HufNode<T> right = nodes.get(nodes.size() - 2);
            HufNode<T> parent = new HufNode<T>();
            parent.setWeight(left.getWeight() + right.getWeight());//生成新节点，新节点的权重 = 两个权重最小节点的和
            parent.setLeft(left);
            parent.setRight(right);
            nodes.remove(left);         //把原来的节点移出队列
            nodes.remove(right);
            nodes.add(parent);          //新节点入队
        }
        return nodes.get(0);            //取出唯一的节点
    }
}
