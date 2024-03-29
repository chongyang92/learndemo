package com.lchy._10内部类_匿名内部类_重点;

/**
    目标：匿名内部类概述

    什么是匿名内部类？
        就是一个没有名字的局部内部类
        匿名内部类的目的就是为了简化代码，也是开发常用的形式。

    匿名内部类的格式：
        new 类名|抽象类|接口(形参){
            方法重写
        }

    匿名内部类特点：
        1.匿名内部类是一个没有名字的内部类
        2.匿名内部类一旦写出来，就会立即创建一个匿名内部类的对象返回。
        3.匿名内部类的对象的类型相当于当前new的哪个类型的样子
        外部类名.class
        外部类名$1.class
        外部类名$2.class
 */
public class Anonymity {

    //构造方法中
    public Anonymity(){
        Dog dog = new Dog() { //匿名内部类，new 后面可以是类名
            private int age;
            //也可以不重写lookdoor方法
            @Override
            public void lookdoor() {
                System.out.println("狗看门");
            }
        };
        dog.lookdoor();
    }

    //代码块中
    static{
        Dog dog = new Dog() { //匿名内部类，new 后面可以是类名
            //也可以不重写lookdoor方法
            @Override
            public void lookdoor() {
                System.out.println("狗看门");
            }
        };
        dog.lookdoor();
    }

    public static void main(String[] args) {
        //在main方法内的内部类，局部内部类
        /*class A{
            private String name;

            public void test(){
            }
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        A a = new A();
        a.test();*/

        Animal animal = new Animal() { //匿名内部类，new 后面可以是抽象类，在{}内实现abstract方法
            @Override         //必须重写
            void run() {
                System.out.println("狗跑");
            }
        };
        animal.run();
        //animal.go();

        //Dog dog = new Dog() { //匿名内部类，new 后面可以是类名
        new Dog() { //匿名内部类，new 后面可以是类名
            //也可以不重写lookdoor方法
            @Override
            public void lookdoor() {
                System.out.println("狗看门");
            }
        }.lookdoor();
        //dog.lookdoor();

        //换成lambda之后的形式其中()中的参数是  height -> System.out.println("飞起来吧");
        //一个参数可以不用写(),一条语句也不用写{}
        //接口中有且仅有一个方法的，才可以改成lambda表达式
        Flyable flyable = new Flyable() {//匿名内部类，new 后面可以是接口,接口中只有一个方法，可以使用lambda表达式
            @Override
            public void fly(int height) {
                System.out.println("飞起来吧");
            }
            //这里如果有两个抽象方法，Flyable就不能用lambda表达式了
            /*@Override
            public void up() {
                System.out.println("ddd");
            }*/
        };
        flyable.fly(5);
    }
}

//能不能不要Cat这个子类，那么就需要new 抽象类
class Cat extends Animal{

    @Override
    void run() {
        System.out.println("猫跑的快");
    }
}

abstract class Animal{
    public Animal(){}
    public Animal(String name){}
    abstract void run();

    /*public void go(){
        System.out.println("开始go");
    }*/
}

class Dog {
    public void lookdoor(){
        System.out.println("狗看门");
    }
}

interface Flyable{
    void fly(int height);
    //void up();//这里如果有两个抽象方法，Flyable就不能用lambda表达式了
}