package com.lchy._10继承后_成员方法的访问特点;

/**
 * 目标：继承后-成员方法的访问特点
 * 就近原则:
 *      代码块有找代码块，子类有找子类，子类没有找父类，父类没有报错
 * 小结：
 *      子类优先使用自己的方法
 */
public class TestDemo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.run();
        cat.eat();
    }
}

class Animal{
    public void run() {
        System.out.println("动物可以跑");
    }
    public void eat() {
        System.out.println("动物吃东西");
    }
}

class Cat extends Animal {
    public void run() {
        System.out.println("猫跑的贼块！");
    }

}
