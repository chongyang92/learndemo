package com.lchy._03List系列集合的使用;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//Collection实现类遍历时，删除元素
public class ListDemo04 {
    public static void main(String[] args) {
        Set<String> lists = new HashSet<>();
        lists.add("java1");
        lists.add("java2");
        lists.add("java2");
        lists.add("java2");
        lists.add("java2");

        /*for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i).equals("java2")){
                lists.remove(i);
            }
            System.out.println(lists.get(i));
            System.out.println("list.size:" + lists.size());
        }*/

        for (String s : lists) {
            System.out.println(s);

        }

        //将对元素去重
        LinkedHashSet<String> strings = new LinkedHashSet<>(lists);
        System.out.println("strings:"+strings);
    }
}
