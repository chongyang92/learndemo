package com.lchy._10排序算法冒泡_选择_排序;

import java.util.Arrays;

/**
    目标：选择排序
    当前位置和后面每一个进行比较，后面比当前大了，值互换
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5,3,9,7,19,4,10,2,8,110};

        //这里的i和j代表两个指针
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {//比较的次数，总数-1次
            for (int j = i+1; j < arr.length ; j++) {//表示前面数的大小是排好序的
                if(arr[i]>arr[j]){
                    index = arr[i];
                    arr[i] = arr[j];
                    arr[j] = index;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
