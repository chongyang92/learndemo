package com.lchy._01知识回顾;

/**
 * 目标：封装概念的回顾
 * 面向对象的三大特征：封装、继承、多态
 * 是Java语言的风格，是我们在开发过程中需要遵循的
 *
 * 封装的作用：
 *      1、提高安全性；
 *      2、提高组件化 set体系、get体系，比如改一个成员变量的类型，可以在set和get方法中做
 * 封装的规范：
 *      1、建议成员变量都私有，用private修饰；
 *      2、提供成套的setget方法暴露成员变量的取值和赋值。
 * 总结：
 *      核心思想：合理隐藏，合理暴露。
 */
public class Package03 {
    private String name;
    private int age;

    public Package03() {
    }

    public Package03(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Package03{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
