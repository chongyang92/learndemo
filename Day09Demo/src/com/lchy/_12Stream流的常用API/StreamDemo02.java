package com.lchy._12Stream流的常用API;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
    目标：Stream流的常用API

    foreach:逐一处理(遍历)
    count:统计个数
        --long count();
    filter:过滤元素
        -- Stream<T> filter(Predicate<? super T> predicate)
    limit:获取前几个元素
    skip:跳过前几个
    map（映射）:加工方法（把原来的元素加工以后，从新放上去）:加瓶盖
        -- <R> Stream<R> map(Function<? super T, ? extends R> mapper);
    concat:合并流
 */
public class StreamDemo02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");
        System.out.println("-----匿名内部类");
        //需求：把名字都加上"优秀的：XXX"
        list.stream().map(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return "优秀的：" + s;
            }
        }).forEach(System.out::println);
        System.out.println("-------lambda表达式-------");
        list.stream().map((Function<String, Object>) s -> "优秀的：" + s).forEach(System.out::println);
        System.out.println("-------最简lambda表达式-------");
        list.stream().map(s -> "优秀的：" + s).forEach(System.out::println);
        list.stream().map(String::new).forEach(System.out::println);

        //需求：把名称都加工成学生对象放上去！
        list.stream().map(name -> new Student(name)).forEach(System.out::println);
        list.stream().map(Student::new).forEach(System.out::println);
    }
}
