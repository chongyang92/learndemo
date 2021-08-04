package com.lchy._10自定义注解;

/**
    目标：我们之前都是别人写好的注解，今天我们自己来做注解。

    自定义注解的格式：
    [修饰符] @interface 注解名{
        // 注解属性
    }


 */
@Book

public class MyBook {
    @Book
    @MyTest
    public static void main(String[] args) {

    }
}

@interface Book{}

@interface MyTest{}