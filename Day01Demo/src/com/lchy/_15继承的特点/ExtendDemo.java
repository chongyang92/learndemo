package com.lchy._15继承的特点;

import java.io.IOException;

/**
 * 目标：继承的特点
 *
 *      1.单继承：一个类只能继承一个直接父类；
 *          为什么Java是单继承？
 *              答反证法。假如Java可以多继承，看如下代码
 *              class A{
 *                  public void test(){
 *                      System.out.println("A");
 *                  }
 *              }
 *              class B{
 *                  public void test(){
 *                      System.out.println("B");
 *                  }
 *              }
 *              class C extends A, B{
 *                  public static void main(String[] args) {
 *                      C c = new C();
 *                      c.test();//出现二议性
 *                  }
 *              }
 *
 *      2.多层继承，一个类可以间接继承多个父类(家谱)
 *      3.一个类可以有多个子类
 *      4.一个类要么默认继承了Object，要么间接继承Object类，Object是祖宗类。
 */
public class ExtendDemo {

}

class A{
    public Number getName()throws Exception {
        return 5;
    }
    public Object getName(int a) throws IOException {
        return a;
    }
}
class E extends A{
    public Integer getName(String name)throws Exception {
        return 5;
    }
}

class B{}

class C extends B{}
class D extends C{}


//class C extends A,B{}