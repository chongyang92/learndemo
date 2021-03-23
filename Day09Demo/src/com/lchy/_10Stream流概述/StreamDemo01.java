package com.lchy._10Stream流概述;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
    目标：演示Stream流的强大

    什么是Stream流？
        在Java 8中，得益于Lambda所带来的函数式编程
        引入了一个全新的Stream流概念，用于结局已有集合/数组类库有的弊端

    Stream流能解决什么问题？
        可以解决已有集合类库或者数组API的弊端
        Stream认为集合和数组操作的API很不好用，所以采用了Stream流简化集合和数组的操作！
    小结：
        Stream流是用来简化集合
 */
public class StreamDemo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //a.先找出姓张的人
        List<String> zhangList = new ArrayList<>();
        for (String s : list) {
            if(s.startsWith("张")){
                zhangList.add(s);
            }
        }
        System.out.println("姓张："+zhangList);
        //b.张姓，名字长度为3的人
        List<String> zhangThreeList = new ArrayList<>();
        for (String s : zhangList) {
            if(s.length() == 3){
                zhangThreeList.add(s);
            }
        }
        System.out.println("姓张，三个字："+zhangThreeList);

        System.out.println("---------Stream流--------");
        //所有的集合和数组都可以.出stream(),即将集合
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张");
            }
        });
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 3;
            }
        });
        //通过lambda表达式简化
        List<String> rsList = list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).collect(Collectors.toList());
        System.out.println(rsList);

    }
}
