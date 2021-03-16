package com.lchy._02Map集合的API;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
    目标：Map集合的常用API

        -public V put(K Key, V value):把指定的键与指定的值添加到Map集合中。
        -public void putAll(Map<? extends K, ? extends V> m)：把另一个集合放到当前集合中
        -public V remove(Object key):把指定的键 所对应的键值对元素 在Map集合中删除，返回被伤处元素的值
        -public V get(Object key)：根据指定的键，在Map集合中获取对应的值。
        -public Set<K> keySet():获取Map集合中所有的键，存储到Set集合中。
        -public Collection<V> values():获取Map集合中所有的值，存储到Collection中
        -public Set<Map.Entry<K,V>> entrySet():获取到Map集合中所有的键值对对象的集合(Set集合)
        -public boolean containKey(Object key):判断该集合中是否有此键。
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> maps = new HashMap<>();
        //1.添加元素：无序，不重复，无索引
        maps.put("iphone",12);
        maps.put("wawa",30);
        maps.put("iphone",20);
        maps.put("huawei",50);
        maps.put("wathch",50);
        System.out.println(maps);

        //2.清空集合
        //maps.clear();
        //System.out.println(maps);

        //3.判断集合是否为空，为空返回true，反之 false
        System.out.println(maps.isEmpty());

        //4.根据键获取对应的值
        System.out.println(maps.get("wawa"));

        //5.根据键删除元素
        Integer iphone = maps.remove("iphone");
        System.out.println(iphone);
        System.out.println(maps);

        //6.判断是否包含某个键，包含返回true
        System.out.println(maps.containsKey("wawa"));
        System.out.println(maps.containsValue("30"));//false,因为值是整数30，不是字符串“30”

        //7.获取全部键的集合，public Set<K> keySet()
        //Map集合的键是无序不重复的，所以返回的是一个Set集合
        Set<String> keySet = maps.keySet();
        for (String s : keySet) {
            System.out.println(s);
        }

        //8.获取全部值的集合：Collection<V> values();
        //值是可以重复的，不能用set集合，用collection，它对元素无要求，
        Collection<Integer> values = maps.values();
        for (Integer value : values) {
            System.out.println(value);
        }

        //9.集合的大小
        System.out.println(maps.size());

        //10.合并其他Map集合(拓展)
        Map<String,Integer> maps2 = new HashMap<>();
        maps2.put("xiaomi",1);
        maps2.put("shoubiao",20);
        maps2.put("watch",60);

        maps2.putAll(maps);
        System.out.println(maps);
        System.out.println("--------------------");
        System.out.println(maps2);

    }
}
