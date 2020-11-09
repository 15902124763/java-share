package com.niki.algorithm.util;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/6
 */
public class Search {
    /**
     * @Description :顺序查找
     * @Author : yarm.yang
     * @Date : 2020/11/6 14:20
     * @Return :
    */
    public int orderSearch(int[] arr, int key){
        for (int i=0 ;i< arr.length; i++){
            if (arr[i] == key){
                return arr[i];
            }
        }
        // 查找失败
        return -1;
    }
    /**
     * @Description :假设数组递增有序
     * @Author : yarm.yang
     * @Date : 2020/11/6 14:41
    */
    public static int middleSearch(int[] arr, int key, int low, int hight){
        if(low < 0 || hight >= arr.length || low > hight || key > arr[hight]){
            return -1;
        }
        int middle = (low + hight)/2;

        if(arr[middle] > key){
            // 左边区域
            middleSearch(arr, key, low, middle -1);
        }else if(arr[middle] < key){
            // 右边区域
            middleSearch(arr, key, middle+1, hight);
        }else{
            return middle;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int i = middleSearch(arr, 3, 0, arr.length -1);
        System.out.println(arr[i]);
    }
}
