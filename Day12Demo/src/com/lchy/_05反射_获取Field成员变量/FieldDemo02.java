package com.lchy._05反射_获取Field成员变量;

import org.junit.Test;

import java.lang.reflect.Field;

/**
    目标：反射获取成员变量：取值和赋值。

    Field的方法：给成员变量赋值和取值
        void set(Object obj, Object value):给对象注入某个成员变量数据
        Object get(Object obj):获取对象的成员变量的值。
        void setAccessible(true):暴力反射，设置为可以直接访问私有类型的属性。
        Class getType(); 获取属性的类型，返回Class对象。
        String getName(); 获取属性的名称。

 */
public class FieldDemo02 {
    @Test
    public void setField() throws Exception{
        //a.获取class类对象
        Class<Dog> dogClass = Dog.class;
        //b.定位name成员变量
        Field name = dogClass.getDeclaredField("name");
        //c.为这个成员变量赋值
        Dog taiDi = new Dog();//先有对象，再给成员变量赋值
        /**
         * 参数一：被赋值的对象。
         * 参数二：该成员变量的值。
         */
        name.setAccessible(true);    //暴力反射
        name.set(taiDi,"泰迪");      //不这么赋值，用公共public的setName方法
        System.out.println(taiDi);
        //d.获取成员变量的值
        String string = name.get(taiDi).toString();
        System.out.println(string);
    }
}
