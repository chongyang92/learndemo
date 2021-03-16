package com.lchy._11二分查找提高检索性能;

/**
    目标：二分查找

    正常查找：从第一个元素开始遍历，一个一个往后找，综合查找比较耗时。
    二分查找：二分查找的前提，数组必须已经排好序。
        每次先与中间的元素进行比较，如果大于往右边找，如果小于往左边找，如果等于返回该元素位置
        如果没有元素，返回-1，综合性能比较好！

 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,7,10,18,22,35,89,90,104,599};
        int number = 22;

        //二分查找：双指针法
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int middle = (start + end) / 2;
            if(number > arr[middle]){
                start = middle + 1;
            }else if(number < arr[middle]){
                end = middle - 1;
            }else if(number == arr[middle]){
                System.out.println(middle);
                return;
            }
        }






















        /*//双指针法
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int middle = (start + end) / 2;
            //拿当前元素和中间元素比较
            if(number > arr[middle]){
                start = middle + 1;
            }else if(number < arr[middle]){
                end = middle - 1;
            }else if(number == arr[middle]){
                System.out.println(middle);
                return ;
            }
        }*/
    }
}
