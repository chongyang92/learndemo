package com.lchy._15单例模式;

/**
    目标：单例设计模式（面试重点，常考）

    什么是单例？
        单例的意思是一个类永远只存在一个对象，不能创建多个对象
    为什么要用单例？
        开发中有很多类的对象我们只需要一个，例如虚拟机对象！任务管理器！(打开后再次打开，还是只有一个窗口)
    如何实现单例？
        单例的实现方式目前有2种方式：
        （1）饿汉单例设计模式：
                --通过类获取单例对象的时候，对象已经提前做好了！饿汉很饿去了包子铺，包子已经准备好了。
                --实现步骤：
                    1.定义一个单例类
                    2.私有的构造器
        （2）懒汉单例设计模式；
 */
public class SingleInstanceDemo01 {
    public static void main(String[] args) {
        SingleInstance02 s1 = SingleInstance02.getInstance();
        SingleInstance02 s2 = SingleInstance02.getInstance();
        System.out.println(s1 == s2);
    }
}
//饿汉单例设计一个单例模式的类
class SingleInstance01{

    public static int id = 110;

    //2.定义一个静态成员变量用于存储一个对象！（饿汉单例，在返回对象的时候，对象要提前创建好）
    public static SingleInstance01 ins = new SingleInstance01();//静态成员变量，类中只有一份

    public static int num = 5;

    private String name = test();

    private int age = testAge();

    //1.把类的构造器私有，构造器只能在本来中访问
    private SingleInstance01(){
        System.out.println("construct");
    }
    //3.提供一个方法返回单例对象
    public static SingleInstance01 getInstance(){
        System.out.println("getInstance");
        return ins;
    }

    public static String test(){
        System.out.println("static test");
        return "hello";
    }

    public int testAge(){
        System.out.println("testAge");
        return 30;
    }

    //有加载但是未被执行
    public static void show(){
        System.out.println("show");
    }
}


