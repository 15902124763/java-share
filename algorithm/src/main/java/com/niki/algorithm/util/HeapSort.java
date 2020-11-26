package com.niki.algorithm.util;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/9
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = { 4,1,9, 8,15,10, 3,2,-1};
        //在堆排序之前，打印初始数组
        System.out.println(Arrays.toString(arr));
        //进行堆排序
        heapSortEsc(arr);
        //进行堆排序之后
        System.out.println("升序：" + Arrays.toString(arr));
        heapSortAsc(arr);
        System.out.println("降序：" + Arrays.toString(arr));
    }

    /**
     * @Description :升序
     * @Author : yarm.yang
     * @Date : 2020/11/9 17:09
    */
    public static void heapSortEsc(int[] arr){
        // 建立大根堆
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 1; i--) {
            swap(arr,0, i);
            maxHeapAdjust(arr, i, 0);
        }
    }

    /**
     * @Description :降序
     * @Author : yarm.yang
     * @Date : 2020/11/9 17:08
    */
    public static void heapSortAsc(int[] arr){
        // 建立小根堆
        buildMinHeap(arr);
        for (int i = arr.length - 1; i >= 1; i--) {
            swap(arr,0, i);
            minHeapAdjust(arr, i, 0);
        }
    }


    private static void buildMaxHeap(int[] arr) {
        int half = arr.length/2;
        for (int i = half; i >= 0; i--) {
            maxHeapAdjust(arr, arr.length, i);
        }
    }

    private static void buildMinHeap(int[] arr){
        int half = arr.length/2;
        for (int i = half; i >= 0; i--) {
            minHeapAdjust(arr, arr.length, i);
        }
    }

    private static void minHeapAdjust(int[] arr, int heapSize, int index) {
        int left = index * 1;
        int right = index * 2 + 1;
        int small = index;
        if (left < heapSize && arr[left] < arr[index]) {
            small = left;
        }
        if (right < heapSize && arr[right] < arr[small]) {
            small = right;
        }

        // 当前子树最大值不在当前根结点
        if (index != small){
            // 交换两个数据
            swap(arr,index,small);
            maxHeapAdjust(arr, heapSize, small);
        }
    }

    private static void maxHeapAdjust(int[] a, int heapSize, int index) {
        int left = index * 2;
        int right = index * 2 + 1;
        int largest = index;

        if (left < heapSize && a[left] > a[index]) {
            largest = left;
        }
        if (right < heapSize && a[right] > a[largest]) {
            largest = right;
        }

        // 当前子树最大值不在当前根结点
        if (index != largest){
            // 交换两个数据
            swap(a,index,largest);
            maxHeapAdjust(a, heapSize, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
