package com.lchy._15收集Stream流;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
    目标：收集Stream流：把Stream流的数据转回成集合。

    引入：
        Stream的作用是：把集合转换成一根传送带，借用Stream流的强大功能进行的操作。
        但是实际开发中数据最终的形式还是应该是集合，最终Stream流操作完毕以后还是要转换成集合。
        这就是收集Stream流。

    收集Stream流的含义：就是把Stream流的数据转回到集合中去。

    Stream流：手段
    集合：才是目的

    流：只能使用一次。
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");

        Stream<String> zhangList = list.stream().filter(s -> s.startsWith("张"));
        //把Stream流转换成Set集合
        Set<String> set = zhangList.collect(Collectors.toSet());
        System.out.println(set);
        //把Stream流转换成List集合
        Stream<String> zhangList1 = list.stream().filter(s -> s.startsWith("张"));
        List<String> list1 = zhangList1.collect(Collectors.toList());
        System.out.println(list1);

        //把Stream流转换成数组
        Stream<String> zhangList2 = list.stream().filter(s -> s.startsWith("张"));
        /*zhangList2.toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });*/
        //zhangList2.toArray(value -> new String[value]);//定义数组的长度
        zhangList2.toArray(String[]::new);//记住这种格式，本来返回的是Object[],如果想转换，就写成String[]::new这种形式，这里的String,要和集合中的List<String>泛型一致

        List<Integer> integerList = new ArrayList<>();
        integerList.add(4);
        integerList.add(5);
        integerList.add(8);
        integerList.add(3);
        integerList.stream().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });
        integerList.stream().toArray(value -> new Integer[value]);
        Integer[] integers = integerList.stream().toArray(Integer[]::new);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
