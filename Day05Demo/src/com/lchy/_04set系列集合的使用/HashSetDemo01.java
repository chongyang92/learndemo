package com.lchy._04set系列集合的使用;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
    目标：Collection集合概述

    什么是集合？
        集合是一个大小可变的容器
        容器中的每个数据称为一个元素 。数据==元素
        集合的特点是：类型可以不确定，大小不确定，集合有很多种，不同的集合特点和使用场景不同。
        数组：类型和长度一旦定义出来就都固定了。
    集合有啥用？
        在开发种，很多时候元素的个数是不确定的。
        而且经常要进行元素的增删改查操作，集合都是非常适合的。
        开发中集合用的更多

    Java中集合的代表是 Collection.
    Collection集合是Java中集合的祖宗类
    学习Collection集合的功能，那么一切集合都可以用这些功能！

    Collection体系：
                              Collection<E>(接口)
                  /                                              \
               List<E>(接口)                                    Set<E>(接口)
           /                    \                         /                   \
    ArrayList<E>(实现类)  LinkedList<E>(实现类)   HashSet<E>(实现类)        TreeSet<E>(实现类)
                                                     /
                                              LinkedHashSet<E>(实现类)

    特点：
        Collection<E>(接口)：单列集合的顶层接口.继承了Iterable接口
        List<E>(接口):添加元素有序，可重复，有索引。
            --ArrayList:添加的元素有序，可重复，有索引。
            --LinkedList:添加的元素有序，可重复，有索引。

        Set<E>(接口)：添加的元素是无序，不重复，无索引。
            --HashSet:添加的元素是无序，不重复，无索引。
            --LinkedHashSet:添加的元素有序，不重复，无索引。
            --TreeSet:不重复，无索引，按照大小默认升序排序！

    研究两个问题(面试热点)
        1）Set集合添加的元素是不重复的，是如何去重复的？
        2）Set集合无序的原因是什么？


 */
public class HashSetDemo01 {
    public static void main(String[] args) {
        //无序，不重复，无索引
        Set<String> sets = new HashSet<>();
        sets.add("Mybatis");
        sets.add("Java");
        sets.add("Java");
        sets.add("Mysql");
        sets.add("Mysql");
        sets.add("Spring");
        System.out.println(sets);
    }
}
