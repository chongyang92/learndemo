package com.lchy._11Stream流的获取;

import java.util.*;
import java.util.stream.Stream;

/**
    目标：Stream流的获取

    Stream流式思想的核心：
        是先得到集合或者数组的Stream流（就是一根传送带）
        然后就用这个Stream流操作集合或者数组的元素
        然后用Stream流简化替代集合操作的API

    集合获取流的API：
        （1）default Stream<E> stream();

    小结：
        集合获取Stream流用 stream()
        数组：Arrays.stream(数组) / Stream.of(数组)
 */
public class StreamDemo01 {
    public static void main(String[] args) {
        /**----------Collection集合获取流---------*/
        //Collection集合如何获取Stream流
        Collection<String> collection = new ArrayList<>();
        Stream<String> stream = collection.stream();

        /**------------Map集合获取流------------*/
        Map<String,Integer> map = new HashMap<>();
        //先获取键的Stream流
        Stream<String> keyss = map.keySet().stream();
        //先获取值的Stream流
        Stream<Integer> valuess = map.values().stream();
        //获取键值对的Stream流(key=value:Map.Entry<String,Integer>)
        Stream<Map.Entry<String, Integer>> keyAndValues = map.entrySet().stream();

        /**------------数组获取流----------*/
        //数组也有Stream流
        String[] strings = new String[]{"java", "javaEE", "Spring Boot"};
        Stream<String> arrStr = Arrays.stream(strings);
        Stream<String> arrStr1 = Stream.of(strings);
        Stream.of(collection);

    }

}


enum SS{
    HA("ha",6),
    HE("he"),
    HEI("hei",5);
    private String name;
    private int age;

    SS(String name, int age){
        this.name = name;
        this.age = age;
    }
    SS(String name){
        this.name = name;
    }
}