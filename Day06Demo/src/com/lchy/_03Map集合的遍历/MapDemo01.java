package com.lchy._03Map集合的遍历;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.DelayQueue;

/**
    目标：Map集合的遍历方式

    Map集合的遍历方式有3种
        （1）keySet  "键找值"的方式遍历：先获取Map集合全部的键，再根据遍历找键值。
        （2）entrySet "键值对"的方式遍历：难度较大。
        （3）JDK1.8开始之后的新技术：Lambda表达式。

    a."键找值"的遍历方式
        1.先获取Map集合的全部键的Set集合
        2.遍历键的Set集合，然后通过键找值。

    b.”键值对“的遍历方式
        1.把Map集合转换成一个Set集合：Set<Map.Entry<K,V>> entrySet();
        2.此时键值对元素的类型就确定了，类型是键值对实体类型：Map.Entry<K,V>
        3.接下来就可以用foreach遍历这个Set集合，类型用Map.Entry<K,V>

    c.JDK1.8开始之后的新技术：Lambda表达式。
 */
public class MapDemo01 {
    public static void main(String[] args) {
        Map<String,Integer> maps = new HashMap<>();
        //1.添加元素： 无序，不重复，无索引
        maps.put("wawa",30);
        maps.put("iphone",100);
        maps.put("huawei",2000);
        maps.put("wathch",1000);

        //a.键找值遍历方式
        //获取当前Map集合的全部键的集合
        Set<String> keys = maps.keySet();
        //b.通过遍历键然后通过键获取对应的值
        for (String key : keys) {
            Integer value = maps.get(key);
            System.out.println("keySet: "+value);
        }
        System.out.println("---------------");
        /**
            "键值对"的方式遍历：更加面向对象的方式，代码复杂。

            "键值对"想把键值对当成一个整体遍历，也就是直接使用foreach遍历；
            for(被遍历集合的元素类型  变量 :  集合名称){

            }
            但是发现Map集合的键值对数据直接是没有元素类型的，foreach无法直接遍历Map集合。
                👇
            把Map集合通过代码Set<Map.Entry<K,V>> entrySet()转换成Set集合。

            Set<Map.Entry<String,Integer>> entries = maps.entrySet();

            entries = [(huawei=1000), (wathch=10), (wawa=20), (iphone=100)]
            //          entry
            此时键值对元素才能作为一个整体就有了类型。类型是Map.Entry<String,Integer>实体类型
         */

        Set<Map.Entry<String, Integer>> entries = maps.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ":" + value);
        }

        System.out.println("---------------");

        //lambda表达式
        maps.forEach((k,v) ->{
            System.out.println(k + "=>" + v);
        });
    }
}
