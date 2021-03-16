package com.lchy._10排序算法冒泡_选择_排序;

import java.util.Arrays;

/**
    目标：冒泡排序

    想象一下，一瓶水里，从上到下有一列不大小无序的气泡，现在要求
    最大的气泡要在最上面，最小的要在最下面。

    每一次从最下面开始，相邻气泡，总让大的在上面
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,3,9,7,19,4,10,2,8};

        //每次从0开始，
        int index = 0;//做交换
        for (int i = 0; i < arr.length - 1; i++) {//总共需要多少次比较，i记录了比较次数
            for (int j = 0; j < arr.length -1 -i; j++) {//j表示比较指针移动的位置，从0到数组长度-1-i
                if(arr[j] > arr[j+1]){//j表示比较指针
                    index = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = index;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
