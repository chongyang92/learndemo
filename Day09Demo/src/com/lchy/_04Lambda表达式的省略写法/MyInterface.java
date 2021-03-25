package com.lchy._04Lambda表达式的省略写法;

import java.util.Comparator;
import java.util.concurrent.Callable;

@FunctionalInterface
public interface MyInterface {
    void test(String s);
    boolean equals(Object obj);
    int hashCode();
    default void show(){
        System.out.println("show");
    }
    static void fun(){
        System.out.println("static");
    }
    private void prishow(){
        System.out.println("prishow");
    }
}
