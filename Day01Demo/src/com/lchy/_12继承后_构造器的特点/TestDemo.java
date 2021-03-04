package com.lchy._12继承后_构造器的特点;

/**
 * 目标：继承后-构造器的特点
 *
 * 特点：
 *      子类构造器的第一行默认一定会先访问父类的无参构造器，再执行子类自己的构造器。
 * 为什么子类构造器会先调父类无参构造器
 * 1、子类构造器的第一行默认有一个super()来调用父类无参构造器，写不写都存在！
 * 2、子类继承父类，子类得到父类属性和行为，
 *      当我们调用了子类构造器初始化对象数据时，必须先调用父类构造器初始化继承自父类的属性和行为。
 */
public class TestDemo {
    public static void main(String[] args) {
        Tiger tiger = new Tiger("老虎");
    }

}

class Animal{
/*    public Animal(){
        System.out.println("父类无参构造器");
    }*/

}

class Tiger extends Animal{
    public Tiger(){
        super();//默认存在
        System.out.println("子类无参构造器");
    }
    public Tiger(String name){
        System.out.println("子类有参构造器");
    }
}
