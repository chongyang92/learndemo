package com.lchy._06可变参数;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
    目标：可变参数。

    可变参数作用在形参中可以接收多个数据。
    可变参数的格式：数据类型...参数名称

    可变参数的作用：
        传输参数非常灵活，方便。
            可以不传输参数。
            可以传输一个参数。
            可以传输多个参数。
            可以传输一个数组。

    可变参数在方法内部本质上就是一个数组。
    可变参数的注意事项：
        1.一个形参列表中可变参数只能有一个！
        2.可变参数必须放在形参列表的最后面！
 */
public class MethodDemo {
    public static void main(String[] args) {
        sum();
        sum(10);
        sum(10,20);
        sum(10,20,30);
        //sum(new Integer[]{10,20,50,70,90});//不支持自动拆装箱
        sum(new int[]{10,20,50,70,90});

        get();
        get("hi");
        get("hello","java");
        get(new String[]{"ni","hao"});

        gett(Short.valueOf((short) 2),4);
        gett(Integer.valueOf(4));
        gett(new Integer[]{2,4,6});

        //gettt();
        //gettt(3);
        gettt(new Double[]{3.5,5.9});
    }
    //public static void sum(int age, int... nums){可变参数只能放最后面
    public static void sum(int... nums){
        //可变参数在方法内部本质上就是一个数组int[]
        System.out.println("元素个数：" + nums.length);
        System.out.println("元素内容："+ Arrays.toString(nums));
        System.out.println("--------------");
    }

    public static void get(String... str){
        //可变参数在方法内部本质上就是一个数组String[]
        System.out.println("字符串长度：" + str.length);
        System.out.println("字符串内容："+ str);
        System.out.println("实际字符串内容："+ Arrays.toString(str));
        System.out.println("--------------");
    }

    public static void gett(Object... num){
        //可变参数在方法内部本质上就是一个数组Number[]
        System.out.println("数字长度：" + num.length);
        System.out.println("数字内容："+ num);
        System.out.println("实际数字内容："+ Arrays.toString(num));
        System.out.println("--------------");
    }

    public static void gettt(Object[] arr){
        //可变参数在方法内部本质上就是一个数组Number[]
        System.out.println("数组长度：" + arr.length);
        System.out.println("数组内容："+ arr);
        System.out.println("实际数组内容："+ Arrays.toString(arr));
        System.out.println("--------------");
    }
}
