package com.lchy._03多态_引用类型自动类型转换;

/**
    目标：引用数据类型的自动转换

    基本数据类型转换
        1.小范围类型的变量或值可以直接赋值给大范围类型的变量。
        2.大范围类型的变量或者值必须强制类型转换给小范围类型的变量。

    引用数据类型转换思想是一样的：
        父类类型的范围 > 子类类型的范围。
        Animal           Cat

    引用数据类型的自动类型转换语法：
        1.子类类型的对象或者变量可以自动类型转换赋值给父类类型的变量。
    小结：
        引用类型的自动类型转换并不能解决多态劣势
 */
public class PolymorphicDemo {
    public static void main(String[] args) {
        //1.引用类型的自动类型转换
        Animal animal = new Cat();

        //2.引用类型的自动类型转换：小范围变量赋值给大范围的变量
        Cat cat = new Cat();
        Animal a = cat;
    }
}

class Animal{}

class Cat extends Animal{}