package com.lchy._07暴力攻击集合泛型;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
    拓展
        1.反射可以破环面向对象的封装性（暴力反射）。
        2.同时可以破坏泛型的约束性。
 */
public class ReflectDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //泛型只能工作在编译阶段，运行阶段泛型就消失了
        //反射工作在运行时阶段
        List<Double> scores = new ArrayList<>();
        scores.add(98.6);
        scores.add(99.6);
        scores.add(97.5);
        scores.add(90.7);
        //scores.add("北京");//泛型在编译阶段检查类型
        scores.forEach(System.out::println);

        //拓展：通过反射暴力的注入一个其他类型的数据进去。
        //a.先得到激活对象的Class文件对象
        Class<? extends List> aClass = scores.getClass();
        //b.从ArrayList的Class对象中定位add方法
        Method add = aClass.getDeclaredMethod("add", Object.class);
        //c.触发scores集合对象中的add执行（运行阶段，泛型不能约束了）
        add.invoke(scores,"北京");
        System.out.println(scores);
        //scores.forEach(System.out::println);
    }
}
