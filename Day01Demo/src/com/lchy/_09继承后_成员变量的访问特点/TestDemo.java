package com.lchy._09继承后_成员变量的访问特点;

/**
 * 目标：继承后-成员变量的访问特点
 * 就近原则:
 *      代码块有找代码块，子类有找子类，子类没有找父类，父类没有报错
 */
public class TestDemo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.show();
    }
}

class Animal{
    public String name = "动物名称";
}

class Cat extends Animal{
    public String name = "子类名称";
    public void show(){
        String name = "局部变量名称";
        System.out.println(name);//就近原则
        System.out.println(this.name);
        System.out.println(super.name);
    }
}
