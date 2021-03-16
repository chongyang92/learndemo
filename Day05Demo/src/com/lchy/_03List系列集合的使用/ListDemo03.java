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
    LinkedList也是List的实现类：底层是基于链表的，增删比较快，查询慢！
    LinkedList是支持双链表，定位前后的元素是非常快的，增删首位的元素也是最快的
    所以LinkedList除了拥有List集合的全部功能还多了很多操作首位元素的特殊功能：
        -public void addFirst(E e):将指定元素插入此列表的开头。
        -public void addLast(E e):将指定元素添加到此列表的结尾。
        -public E getFirst():返回此列表的第一个元素
        -public E getLast():返回此列表的最后一个元素。
        -public E removeFirst():移除并返回此列表的第一个元素
        -public E removeLast():移除并返回此列表的最后一个元素
        -public E pop():从此列表中所表示的堆栈中弹出一个元素。
        -public void push(E e):将元素推入此列表所表示的堆栈

    小结：
        LinkedList是支持双链表，定位前后的元素是非常快的，增删首尾的元素也是最快的。
        所以提供了很多操作首尾元素的特殊API可以做栈和队列的实现。

        如果查询多而增删少用ArrayList集合(用的最多)
        如果查询少而增删首尾较多用LinkedList集合。
 */
public class ListDemo03 {
    public static void main(String[] args) {
        //1.用LinkedList做一个队列：先进先出，后进后出
        LinkedList<String> queue = new LinkedList<>();
        //入队
        queue.addLast("1号");
        queue.addLast("2号");
        queue.addLast("3号");
        queue.addLast("4号");
        System.out.println(queue);
        //出队
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);

        //做一个栈
        LinkedList<String> stack = new LinkedList<>();
        stack.push("第1颗子弹");
        stack.push("第2颗子弹");
        stack.push("第3颗子弹");
        stack.push("第4颗子弹");
        stack.push("第5颗子弹");
        System.out.println(stack);

        stack.pop();
        stack.pop();
        System.out.println(stack);

    }
}
