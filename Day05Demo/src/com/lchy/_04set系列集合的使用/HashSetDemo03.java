package com.lchy._04set系列集合的使用;


import java.util.Map;

/**
    目标：Set系列集合元素无序的根本原因(面试必考)

    Set系列集合添加元素无序的根本原因是因为底层采用了哈希表存储元素。

    JDK1.8之前： 哈希表 = 数组 + 链表 + (哈希算法)
    JDK1.8之后： 哈希表 = 数组 + 链表 + 红黑树 + (哈希算法)

        当链表长度超过阈值(8)时，将链表转换为红黑树，这样大大减少了查找时间。

    小结：
        Set系列集合是基于哈希表存储数据的。
        它的增删改查的性能都很好！！但是它是无序不重复的！如果不在意当然可以使用！
 */
public class HashSetDemo03 {
    public static void main(String[] args) {

    }
}
