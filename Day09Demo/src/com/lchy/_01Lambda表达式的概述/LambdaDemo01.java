package com.lchy._01Lambda表达式的概述;

/**
    目标：Lambda表达式

    什么是Lambda表达式？
        Lambda表达式是JDK1.8开始之后的新技术，是一种代码的新语法
        是一种特殊写法
        作用：“核心作用是为了简化匿名内部类的代码写法”

    Lambda表达式的格式：
        (匿名内部类被重写方法的形参列表) -> {
            被重写方法的方法体代码
        }

    -> 就是一个新语法，没有实际含义，但是不能省略

    Lambda表达式的使用前提：
        （1）Lambda表达式并不能简化所有匿名内部类写法
        （2）Lambda表达式只能简化接口中只有一个抽象方法的匿名内部类形式

    Lambda表达式只能简化函数式接口的匿名内部类写法：
        a.首先必须是接口
        b.接口中只能由一个抽象方法

    小结：
        lambda表达式只能简化接口中只有一个抽象方法的匿名内部类写法
        接口中只有一个个抽象方法的接口称为函数式接口
        Lambda只能简化函数式接口的匿名内部类写法
 */
public class LambdaDemo01 {
    public static void main(String[] args) {
        //局部内部类
        /*class Thread{
            public long getId(){return 0;}
        }*/
        //匿名内部类
        Thread th = new Thread(){
            @Override
            public long getId() {
                return super.getId();
            }
        };
        //匿名内部类，相当于创建了Thread的子类，但是没有起类名，而是用的父类Thread
        //返回的是子类引用，这就形成了类多态，即Fu fu = new Zi();只不过Zi被省略了，
        //变成了Fu fu = new Fu(){重写的方法}
        Thread t = new Thread(){//
            @Override
            public long getId() {
                return super.getId();
            }
        };
        //匿名内部类，接口多态
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("匿名内部类");
                System.out.println("OK");
            }
        };
        //如果接口中只有一个抽象方法，可以用lambda表达式简化
        Runnable runnable1 = () -> {
            System.out.println("lambda");
            System.out.println("OK");
        };
        //匿名内部类，如果只有一条语句，可以省略{}
        Runnable runnable2 = () -> System.out.println("lambda");

    }
}
