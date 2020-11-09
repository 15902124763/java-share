package com.niki.algorithm.queue;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/4
 */
// 该默认实现get set 方法
@Data
public class QueueData<T> {
    private T data;
    private QueueData next;
}

// 链表实现
class QueueLink<T> {
    // 定义头
    private QueueData head;
    // 队列尾部
    private QueueData tail;
    // 队列长度
    private int size;

    public QueueLink init() {
        if (head == null) {
            head = new QueueData<T>();
            tail = head;
            size = 0;
        }
        return this;
    }

    // 队列头
    public T getHead(){
        return (T)head.getNext().getData();
    }

    // 队尾
    public T getTail(){
        return (T)tail.getData();
    }

    // 入队列，往队尾插入
    public boolean enQueue(Object e){
        QueueData data = new QueueData();
        data.setData(e);
        tail.setNext(data);
        tail = data;
        return Boolean.TRUE;
    }

    // 栈实现
    class QueueStack<T>{
        // 定义头
        private QueueData head;
        // 队列尾部
        private QueueData tail;
        // 队列长度
        private int size;
    }

    public static void main(String[] args) {
        QueueLink<String> link = new QueueLink<String>();
        QueueLink<String> init = link.init();
        System.out.println(init);
        init.enQueue("111");
        init.enQueue("2222");
        init.enQueue("3333");
        System.out.println(init.getHead());
        System.out.println(init.getTail());
    }
}

