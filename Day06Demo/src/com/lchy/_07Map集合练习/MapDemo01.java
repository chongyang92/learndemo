package com.lchy._07Map集合练习;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
    目标： 输出一个字符串中每个字符出现次数。

    分析：
        （1）键盘录入一个字符串。aabbccddaa123。
        （2）定义一个Map集合，键是每个字符，值是其出现的次数。 {a=4 , b=2 ,...}
        （3）遍历字符串中的每一个字符。
        （4）拿着这个字符去Map集合中看是否有这个字符键，有说明之前统计过，其值+1
        没有这个字符键，说明该字符是第一次统计，直接存入“该字符=1”

 */
public class MapDemo01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        Map<Character,Integer> maps = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(maps.containsKey(c)){
                Integer num = maps.get(c);//Integer num = ++maps.get(c)这里会报错，++后面跟的操作数，必须是整型或浮点型变量
                maps.put(c,num + 1);
            }else {
                maps.put(c,1);
            }
        }

        System.out.println(maps);
    }
}
