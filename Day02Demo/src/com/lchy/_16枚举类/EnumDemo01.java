package com.lchy._16枚举类;

/**
    目标：枚举类的概述

    枚举类的作用？
        枚举是用于信息标志和信息分类。
    枚举类的格式：
        修饰符 enum 枚举名称{
            实例1名称，实例2名称...;
        }
    反编译后的枚举源代码
     public final class Sex extends java.lang.Enum<Sex> {
         public static final Sex BOY;//常量
         public static final Sex GIRL;
         public static Sex[] values();
         public static Sex valueOf(java.lang.String);
         static {};
     }
        --枚举类的第一行罗列的必须是枚举类的对象名称
    枚举类的特点：
        1.枚举类是final修饰的，不能被继承。
        2.枚举类默认继承了枚举类型:java.lang.Enum
        3.枚举类的第一行罗列的是枚举类的对象，而且是用常量存储的。
        4.所以枚举类的第一行写的都是常量名称，默认存储了枚举对象。
        5.枚举类的构造器默认是私有的。
        6.枚举类相当于是多例设计模式。
 */
public class EnumDemo01 {
    public static void main(String[] args) {
        Sex boy = Sex.BOY;
        System.out.println(boy);
        System.out.println(boy.ordinal());
        System.out.println(boy.name());
        System.out.println(Sex.valueOf("BOY"));
    }
}

enum Sex{
    BOY,GIRL;
}

