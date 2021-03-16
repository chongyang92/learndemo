package com.lchy._03List系列集合的使用;

import java.util.*;

/**
    目标：List系类集合的遍历方式有：4种。

    List系列集合多了索引，所以多了一种按照索引遍历集合的for循环

    List遍历方式：
        (1)for循环。
        (2)迭代器。
        (3)foreach
        (4)JDK 1.8新技术 lambda表达式

    数组：内存中是一块连续空间，长条
    集合：可大可小
 */
public class ListDemo02 {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("java1");
        lists.add("java2");
        lists.add("java3");
        lists.add("java4");
        lists.add("java5");
        System.out.println("-------原数组-------");
        System.out.println(lists);
        System.out.println("-------(1)for循环-------");
        /*(1)for循环*/
        for (int i = 0; i < lists.size(); i++) {
            /*if(lists.get(i).equals("java2")){//这种删除方式不行，因为lists.size()在删除两个元素后，就变成3了
                lists.remove(i);
            }*/
            System.out.println(lists.get(i));
        }

        System.out.println("-------(2)迭代器-------");
        /*(2)迭代器*/
        Iterator<String> it = lists.iterator();
        while (it.hasNext()){
            String s = it.next();
            /*if(s.equals("java1")){
                lists.remove(s);
            }*/
            System.out.println(s);
        }

        System.out.println("-------(3)foreach-------");
        /*(3)foreach*/
        for (String ele : lists) {
            /*if(ele.equals("java1")){
                lists.remove(ele);
            }*/
            System.out.println(ele);
        }

        System.out.println("-------(4)JDK 1.8新技术 lambda表达式-------");
        /*(4)JDK 1.8新技术 lambda表达式*/
        lists.forEach(System.out::println);
    }
}
