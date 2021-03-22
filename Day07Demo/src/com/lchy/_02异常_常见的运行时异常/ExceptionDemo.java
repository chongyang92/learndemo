package com.lchy._02异常_常见的运行时异常;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
    拓展：常见的运行时异常(面试题)
        运行时异常的概念：
            继承自RuntimeException的异常或其子类。
            编译阶段是不会出错的，它是在运行时阶段可能出现错误。
            运行时异常编译阶段可以处理也可以不处理，代码编译都能通过！

        1.数组索引越界异常：ArrayIndexOutOfBoundException
        2.空指针异常：NullPointerException
            直接输出没有问题，但是调用空指针的变量的功能就会报错！
        3.类型转换异常：ClassCastException
        4.迭代器遍历没有此元素异常：NoSuchElementException
        5.数学操作异常：ArithmeticException
        6.数字转换异常：NumberFormatException
        7.非法状态异常IllegalStateException：流已关闭异常






 */
public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("程序开始。。。");

        //1.数组索引越界异常：ArrayIndexOutOfBoundException
        int[] arrs = {10,20,30};
        System.out.println(arrs[2]);
        //System.out.println(arrs[3]);//此处出现了数组索引越界异常，程序结束

        //2.空指针异常：NullPointerException
        String name = null;
        System.out.println(name);
        //System.out.println(name.length());//此处出现了空指针异常，代码在此处直接执行死亡。

        //3.类型转换异常：ClassCastException
        Object o = "齐天大圣";
        String s = (String)o;
        //Integer i = (Integer)o;

        //4.数字转换异常：NumberCastException
        String number = "23aa";
        //Integer it = Integer.valueOf(number);
        //System.out.println(it+1);

        //5.迭代器遍历异常：NoSuchElementException
        List<String> list = new ArrayList<>();
        list.add("ni");
        list.add("hao");

        Iterator<String> iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();

        //6.数学操作异常：ArithimeticException
        //int c = 10 / 0;
        System.out.println("程序结束。。。");
    }
}

/**异常栈信息，输出代码的错误原因，
 Exception in thread "main" java.lang.ArithmeticException: / by zero
 at com.lchy._02异常_常见的运行时异常.ExceptionDemo.main(ExceptionDemo.java:49)
 */
//NullPointerException
//ArrayIndexOutOfBoundException
//ClassCastException
//NoSuchElementException
//NumberFormatException
//ArithmeticException