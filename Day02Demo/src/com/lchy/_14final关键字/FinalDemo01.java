package com.lchy._14final关键字;

/**
    目标：final关键字讲解

    final是”最终“的含义
    final可以用于修饰类，方法，变量。

    （1）final修饰类：类不能被继承了。
        为什么不能被继承？
        如果被继承了，通常用子类，子类就被覆盖了
    （2）final修饰方法：方法不能被重写
        已经够完善了，无需重写
    （3）final修饰变量：变量有且仅能被赋值一次。

    拓展：abstract和final的关系是什么？ 互斥关系！不能同时出现
 */
public class FinalDemo01 {
}

final class Animal{

}

//final修饰的类不能被继承
//class Cat extends Animal{}