package com.lchy._04Lambda表达式的省略写法;

@FunctionalInterface
public interface MyInterface {
    void test(String s);
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
