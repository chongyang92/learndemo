package com.lchy._05方法引用的概述;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
    目标：方法引用的概述（了解）

    方法引用：
        方法引用是为了进一步简化Lambda表达式的写法
        方法引用的格式：类型或者对象::引用的方法


 */
public class MethodDemo01 {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("java1");
        lists.add("java2");
        lists.add("java3");

        lists.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        lists.forEach((String s)-> {
            System.out.println(s);
        });

        lists.forEach(s -> {
            System.out.println(s);
        });

        lists.forEach(s -> System.out.println(s));

        lists.forEach(System.out::println);
    }
}
