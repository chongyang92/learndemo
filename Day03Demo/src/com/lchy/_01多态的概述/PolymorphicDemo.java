package com.lchy._01多态的概述;

/**
    目标：多态的入门概述

    面向对象的三大特征：封装、继承、多态

    多态的形式：
        父类类型 对象名称 = new 子类构造器；
        接口     对象名称 = new 实现类构造器;

        父类类型的范围 > 子类类型范围

    多态的概念：
        同一个类型的对象(Animal的对象)，执行同一个行为run()，在不同的状态(真正创建的猫对象或狗对象)下会表现出不同的行为特征（猫的run或狗的run）。

    多态的识别技巧：
        对于方法的调用：编译看左边(Animal类的所有方法)，运行看右边（猫或狗对象的方法，重写后用用写的方法）；
        对于变量的调用：编译看左边，运行也看左边；继承中，变量不覆盖；

    多态的使用前提：
        （1）必须存在继承或实现关系；
        （2）必须存在父类类型的变量引用子类类型的对象。
        （3）需要存在方法重写。

 */
public class PolymorphicDemo {
    public static void main(String[] args) {
        Cat cat = new Cat(); //普通对象
        cat.run();
        //父类型 对象名称 = new 子类构造器;
        Animal catAnimal = new Cat();
        catAnimal.run();

        Animal dogAnimal = new Dog();
        dogAnimal.run();

        System.out.println(catAnimal.name);
    }
}

class Dog extends Animal{
    public String name = "狗名称";
    @Override
    public void run() {
        System.out.println("狗在跑");
    }
}

class Cat extends Animal {
    public String name = "猫名称";
    @Override
    public void run() {
        System.out.println("猫在跑");
    }
}

class Animal{
    //变量：编译看左边，运行也看左边
    public String name = "动物名称";

    public void run(){
        System.out.println("动物跑");
    }
}
