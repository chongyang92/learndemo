package com.lchy._08泛型的概述;

import java.util.ArrayList;

/**
    目标：泛型的概述

    什么是泛型？
        泛型就是一个标签：<数据类型>
        泛型可以在编译阶段约束只能操作某种数据类型。
    注意：JDK1.7开始之后，泛型后面的申明可以省略不写
        泛型和集合都只能支持引用数据类型，不支持基本数据类型
 */
public class GenericDemo {
    public static void main(String[] args) {
        //add方法参数是Object类型，如果没有泛型，任何数据都能传入
        ArrayList list = new ArrayList();
        list.add("java");
        list.add("mysql");
        list.add(false);
        list.add(99.9);
        list.add('a');
        System.out.println(list);

        ArrayList<String> listStr = new ArrayList<>();
        listStr.add("java");
        listStr.add("mysql");
        //泛型规定了,只能向list列表里添加String类型字符串
        /*listStr.add(false);
        listStr.add(99.9);
        listStr.add('a');*/
        System.out.println(listStr);

        //只支持引用数据类型，写包装类而不是基本数据类型，例如，写Integer而不是int
        ArrayList<Integer> listInt = new ArrayList<>();
        listInt.add(20);
        listInt.add(50);

        System.out.println(listInt);
    }
}
