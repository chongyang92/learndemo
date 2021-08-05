package com.lchy._05反射_获取Field成员变量;

import org.junit.Test;

import java.lang.reflect.Field;

/**
        目标：反射_获取Filed成员变量对象。

        反射的第一步是先得到Class类对象。

        1.Field getField(String name);
                根据成员变量名获取对应Field对象，只能获得public修饰
        2.Field getDeclaredField(String name);
                根据成员变量名获得对应Field对象，只要申明了就可以得到
        3.Field[] getFiedlds();
                获得所有的成员变量对应的Field对象，只能获得public的
        4.Field[] getDeclaredFields();
                获得所有的成员变量对应的Field对象，只要申明了就可以得到
    小结：
        获取全部成员变量：getDeclaredFields
        获取某个成员变量：getDeclaredfield
 */
public class FieldDemo {
    /**
     * 1.获取全部的成员变量（无论是public 还是private）
     */
    @Test
    public void getDeclaredFields(){
        Class<Dog> dogClass = Dog.class;
        Field[] fields = dogClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    /**
     * 1.获取单个的成员变量（无论是public 还是private）
     */
    @Test
    public void getDeclaredField() throws NoSuchFieldException {
        Class<Dog> dogClass = Dog.class;
        Field field = dogClass.getDeclaredField("school");
        System.out.println(field.getType().getSimpleName());
    }
}

