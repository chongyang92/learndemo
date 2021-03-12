package com.lchy._10自定义泛型类;

import java.util.ArrayList;

/**
    目标：自定义泛型类

    引入：
        我们之前用的泛型都是别人写好的(ArrayList)，接下来我们来自定义泛型类
    泛型类的概念：
        使用了泛型定义的类就是泛型类。其实就是在普通类名后加上<泛型变量>

    泛型类的格式：
        修饰符 class 类名<泛型变量>{

        }
        泛型变量建议使用E, T, K, V
    需求：模拟ArrayList集合自定义一个集合MyArrayList集合
    泛型类的核心思想：是把出现泛型变量(例E|T|K|V)的地方全部替换成传输的真实数据类型(例String)
 */
public class GenericDemo {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("hello");
        myArrayList.add("world");
        myArrayList.add("java");
        System.out.println(myArrayList);
        myArrayList.remove("world");
        System.out.println(myArrayList);
    }
}

//传入一个String,E就是Sting,其方法全部替换为操作String类型的方法，即方法表示的E全部替换为String
class MyArrayList<E>{
    private ArrayList list = new ArrayList();

    public void add(E e){
        list.add(e);
    }

    public void remove(E e){
        list.remove(e);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}