package com.lchy._12Stream流的常用API;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
    目标：Stream流的常用API

    foreach:逐一处理(遍历)
    count:统计个数
        --long count();
    filter:过滤元素
        -- Stream<T> filter(Predicate<? super T> predicate)
    limit:获取前几个元素
    skip:跳过前几个
    map:加工方法
    concat:合并流
 */
public class StreamDemo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");
        //这里Stream<String> filter(Predicate <? spuer String>) ,其中的String
        //是由Stream<String>规定的，而这里的String是由List<String>决定的
        list.stream().filter(s -> s.length() == 3)
                .filter(s -> s.startsWith("张"))
                .forEach(System.out::println);
        System.out.println("------------count--------");
        long count = list.stream().filter(s -> s.length() == 3)
                .filter(s -> s.startsWith("张"))
                .count();
        System.out.println(count);
        System.out.println("------------limt--------");
        list.stream().filter(s -> s.length() == 3)
                .limit(3).forEach(System.out::println);
        System.out.println("------------skip--------");
        list.stream().filter(s -> s.length() == 3)
                .skip(3).forEach(System.out::println);
    }
}
