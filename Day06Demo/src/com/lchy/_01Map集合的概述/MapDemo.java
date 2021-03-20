package com.lchy._01Map集合的概述;

import java.util.HashMap;
import java.util.Map;

/**
    目标：Map集合概述

    Map集合是另一个集合体系
    Collection是单值集合体系

    Map集合是一种双列集合，每个元素包含两个值。
    Map集合的每个元素的格式： key=value(键值对元素)
    Map集合也被称为“键值对集合”

    Map集合的完整格式：{key1 = value1, key2 = value2, key3 = value3 ...}

    Map集合有啥用？
        1.Map集合存储的信息更加的具体丰富。
            Collection:{"成龙", "中国香港", "男", "动作演员", 23, "广州"}
            Map : {name = "成龙", country = "中国香港", sex = "男", job = "动作演员", age = 63, address = "九龙"}

        2.Map集合很适合做购物车这样的系统
            Map: {娃娃=30, huawei = 1000, iphone = 5000}

    注意：集合和泛型都只能支持引用数据类型，集合完全可以称为是对象容器，存储都是对象。

    Map集合的体系：如果把Set集合加上一个附属值，就变成了Map
                             Map<Key,Value>(接口,Map集合的祖宗类)
                       /                                         \
          HashMap<K,V>(实现类，经典的，用的最多)                 TreeMap<K,V>
                /
      LinkedHashMap<K,V>(实现类)

    Map集合的特点：
        1.Map集合的特点都是由键决定的。
        2.Map集合的键是无序的，不重复的，无索引的。
            Map集合后面重复的键对应的元素会覆盖前面的整个元素！
        3.Map集合的值无要求,重不重复没关系。
        4.Map集合的键值对都可以为null。

        HashMap:元素按照键是无序，不重复，无索引，值不做要求。
        LinkedHashMap:元素按照键是有序，不重复，无索引，值不做要求

 */
public class MapDemo {
    public static void main(String[] args) {
        //一行经典代码
        Map<String, Integer> map = new HashMap<>();
        map.put("wawa",1);
        map.put("huawei",200);
        map.put("iphone",40);

        map.put(null,null);
        map.put("wawa",3);
        map.put("telunsu",3);
        map.put(null,null);
        System.out.println(map);
    }
}
