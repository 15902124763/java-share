package com.niki.algorithm.util;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/10/15
 */
public class SortUtil {
    /**
     * @Description :插入排序
     * @Author : yarm.yang
     * @Date : 2020/10/15 9:36
     * @Return :
    */
    public static int[] insertionSort(int[] arr){

        // 从数组的第二位开始
        for(int i=1; i<arr.length; i++){
            // 保存每次需要插入的那个数
            int temp = arr[i];
            int j;
            // 如果i的前一个比自己大，则交换
            for(j=i; j > 0 && arr[j-1] > temp; j--){
                arr[j] = arr[j-1];
            }
            // 将需要插入的数放入这个位置
            arr[j] = temp;
        }
        return arr;
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

    /**
     * @Description :选择排序
     * @Author : yarm.yang
     * @Date : 2020/11/10 10:52
    */
    public static int[] selectSort(int[] arr){
        int startIndex = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = startIndex;j < arr.length; j++){
                // 找到数组后边未排序的最小值，然后交换
                if(arr[j] < arr[startIndex]){
                    int temp = arr[j];
                    arr[j] = arr[startIndex];
                    arr[startIndex] = temp;
                }
            }
            startIndex ++;
        }
        return arr;
    }

    /**
     * @Description :冒泡排序
     * @Author : yarm.yang
     * @Date : 2020/11/10 14:21
     * @Return :
    */
    public static int[] bubbleSort(int[] arr){
        for (int i=0;i < arr.length - 1 ;i++){
            // arr.length - i -1：比较出来大的放到当前序列（0,arr.length - i -1）末尾
            for (int j=0; j < arr.length - i -1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }


    /**
     * @Description :快速排序算法
     * @Author : yarm.yang
     * @Date : 2020/11/10 14:51
    */
    public static void quickSort(int[] list, int left, int right) {
        if (left < right) {
            // 分割数组，找到分割点
            int point = partition(list, left, right);

            // 递归调用，对左子数组进行快速排序
            quickSort(list, left, point - 1);
            // 递归调用，对右子数组进行快速排序
            quickSort(list, point + 1, right);
        }

    }

    /**
     * 分割数组，找到分割点
     */
    private static int  partition(int[] list, int left, int right) {
        // 用数组的第一个元素作为基准数
        int first = list[left];
        while (left < right) {
            while (left < right && list[right] >= first) {
                right--;
            }
            // 交换
            swap(list, left, right);

            while (left < right && list[left] <= first) {
                left++;
            }
            // 交换
            swap(list, left, right);
        }
        // 返回分割点所在的位置
        return left;
    }

    /**
     * 交换数组中两个位置的元素
     */
    private static void swap(int[] list, int left, int right) {
        int temp;
        if (list != null && list.length > 0) {
            temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }

    /**
     * @Description :并归排序
     * @Author : yarm.yang
     * @Date : 2020/11/11 9:35
    */
    public static void mergeSort(int[] arr, int left, int right) {
        if(null == arr) {
            return;
        }
        if(left < right) {
            // 找中间位置进行划分
            int mid = (left+right)/2;
            // 对左子序列进行递归归并排序
            mergeSort(arr, left, mid);
            // 对右子序列进行递归归并排序
            mergeSort(arr, mid+1, right);
            // “合”。 进行归并
            merge(arr, left, mid, right);
        }
    }

    /**
     * @Description :进行归并
     * @Author : yarm.yang
     * @Date : 2020/11/11 9:30
    */
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tempArr = new int[arr.length];
        int leftStart = left;
        int rightStart = mid+1;
        int tempIndex = left;

        while(leftStart <= mid && rightStart <= right) {
            if(arr[leftStart] < arr[rightStart]) {
                tempArr[tempIndex++] = arr[leftStart++];
            } else {
                tempArr[tempIndex++] = arr[rightStart++];
            }
        }

        while(leftStart <= mid) {
            tempArr[tempIndex++] = arr[leftStart++];
        }

        while(rightStart <= right) {
            tempArr[tempIndex++] = arr[rightStart++];
        }

        while(left <= right) {
            arr[left] = tempArr[left++];
        }
    }


    public static void main(String[] args) {
        int[] arr={5, 1,1,6,8,4,};
//        int[] ints = SortUtil.insertionSort(arr);
//        int[] ints = SortUtil.shellSort(arr);
//        int[] ints = SortUtil.selectSort(arr);
//        int[] ints = SortUtil.bubbleSort(arr);
          SortUtil.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
