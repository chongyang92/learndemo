package com.lchy._04set系列集合的使用;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
    目标：LinkedHashSet

    是HashSet的子类，元素是”有序“，不重复，无索引。 有序是指按照添加顺序存储

    LinkedHashSet底层依然是使用哈希表存储的，
    但是每个元素都额外带一个链（下一个元素的地址）来维护添加顺序！
    不光增删查快，还有序。缺点是多了一个存储顺序的链会占内存空间！！而且不允许重复，无索引。

    总结：
        如果希望元素可以重复，又有索引，查询要快，用ArrayList(用的最多)
        如果希望元素可以重复，又有索引，增删要快，用LinkedList(适合查询元素比较少的情况，经常要首尾操作元素的情况)
        如果希望增删改查快，但是元素不重复以及无序无索引，那么用HashSet集合
        如果希望增删改查都快且有序，但是元素不重复以及无索引，那么用LinkedHashSet


 */
public class HashSetDemo04 {
    public static void main(String[] args) {
        //有序，不重复，无索引
        Set<String> sets = new LinkedHashSet<>();
        sets.add("Mybatis");
        sets.add("Java");
        sets.add("Java");
        sets.add("Mysql");
        sets.add("Mysql");
        sets.add("Spring");
        System.out.println(sets);
    }
}
