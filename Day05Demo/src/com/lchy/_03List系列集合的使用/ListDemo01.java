package com.lchy._03List系列集合的使用;

import java.util.*;

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

    List集合继承了Collection集合的全部功能，同时因为List系列集合又索引
    ArrayList实现类集合底层基于数组存储的，查询快，增删慢。
    因为List集合多了索引，所以多了很多按照索引操作元素的功能：
        -public void add(int index, E element):将指定的元素，添加到该集合中的指定位置上。
        -public E get(int index):返回集合中指定位置的元素。
        -public E remove(int index):移除列表中指定位置的元素，返回的是被移除的元素。
        -public E set(int index, E element):用指定元素替换集合中指定位置的元素，返回值的更新

    小结：
        List集合：有序，可重复，有索引
        ArrayList实现类底层基于数组存储数据的，查询快，增删慢。
        开发中ArrayList集合用的最多。
 */
public class ListDemo01 {
    public static void main(String[] args) {
        //1.创建一个ArrayList集合对象：这是一行经典代码
        List<String> lists = new ArrayList<>();
        lists.add("java1");
        lists.add("java1");
        lists.add("java2");
        lists.add("java3");
        System.out.println(lists);
        //2.在某个索引位置插入元素
        lists.add(2,"mysql");//原2号位置后所有元素后移一位
        System.out.println(lists);
        //3.根据索引删除元素，返回被删除元素
        lists.remove(2);
        System.out.println(lists);
        //4.根据索引获取元素
        System.out.println(lists.get(2));
        //5.修改索引位置处的元素
        lists.set(2,"mybatis");


        System.out.println("-------------LinkedList排序--------");
        LinkedList<Integer> integerList = new LinkedList<>();
        integerList.add(2);
        integerList.add(5);
        integerList.add(1);
        integerList.add(9);
        integerList.add(0);
        System.out.println(integerList);
        integerList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        System.out.println(integerList);
    }
}
