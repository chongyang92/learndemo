package com.lchy._05Collections工具类;

import java.util.*;

/**
    目标：Collections工具类的使用。

    java.utils.Collection:是集合工具类
    Collections并不属于集合，是用来操作集合的工具类。
    Collections有几个常用的API：
        -public static <T> boolean addAll(Collection<? super T> c, T... elements)
            给集合对象批量添加元素!   这是一个泛型方法，T类型是根据传入参数T... elements规定的
        -public static void shuffle(List<?> list):打乱集合顺序。
        -public static <T> void sort(List<T> list):将集合中元素按照默认规则排序
        -public static <T> void sort(List<T> list, Comparator<? super T>):将集合中元素按照指定规则排序
 */
public class CollectionsDemo01 {
    public static void main(String[] args) {
        //1.给集合批量添加元素
        /**
         * 参数一：被添加元素的集合
         * 参数二：可变参数，一批元素
         */
        Collection<Object> names = new ArrayList<>();//<? super T>理解：T类型是根据传入参数T... elements规定的，？是names规定的泛型变量。
        Collections.addAll(names,"曹操","贾乃亮","王宝强");
        System.out.println(names);
        //2.打乱集合的顺序
        //注意：只能打乱有序的List集合
        List<String> newNames = new ArrayList<>();
        Collections.addAll(newNames,"曹操","贾乃亮","王宝强");
        Collections.shuffle(newNames);
        System.out.println(newNames);

        //3.List集合升序排序。
        List<Double> scores = new ArrayList<>();
        Collections.addAll(scores,98.5,66.5,59.5,99.5);
        Collections.sort(scores);//默认升序
        System.out.println(scores);
    }
}
