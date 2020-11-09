package com.niki.algorithm.util;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/10/15
 */
public class SortUtil {
    /**
     * @Description :快速排序
     * @Author : yarm.yang
     * @Date : 2020/10/15 9:36
     * @Return :
    */
    public static int[] insertionSort(int[] ins){

        for(int i=1; i<ins.length; i++){
            // 保存每次需要插入的那个数
            int temp = ins[i];
            int j;
            for(j=i; j > 0 && ins[j-1]>temp; j--){
                ins[j] = ins[j-1];
            }
            // 将需要插入的数放入这个位置
            ins[j] = temp;
        }
        return ins;
    }

    /**
     * @Description :希尔排序
     * @Author : yarm.yang
     * @Date : 2020/10/15 10:32
     * @Return :
    */
    public static int[] shellSort(int[] arr) {
        // gap 为间隔分组，gap 每一轮递减 2 倍
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第 gap 个元素开始向后遍历获取待插入值
            for (int i = gap; i < arr.length; i++) {
                // 初始化待插入值
                int insertValue = arr[i];
                // 初始化待插入位置
                int insertIndex = i;
                // 在不越界的前提下，寻找待插入位置
                while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {
                    // 将前 gap 个位置的值后移 gap
                    arr[insertIndex] = arr[insertIndex - gap];
                    // 将 insertIndex 前移 gap 个位置
                    insertIndex -= gap;
                }
                arr[insertIndex] = insertValue;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr={5, 1,1,6,8,4,};
//        int[] ints = SortUtil.insertionSort(arr);
        int[] ints = SortUtil.shellSort(arr);
        System.out.println(Arrays.toString(ints));
    }
}
