package com.lchy._04成员方法的分类和访问;

import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 目标：成员变量的分类和访问
 *
 *  按照有无static修饰成员变量分为：
 *      (1)静态成员变量：有static修饰，属于类本身与类一起加载一次，直接用类名访问即可。
 *      (2)实例成员变量：无static修饰，属于类的每个对象的，必须先创建对象，再用对象来访问。
 *  成员变量的访问语法：
 *      静态成员变量访问：
 *          类名.静态成员变量。
 *          对象.静态成员变量。(不推荐)
 *      实例成员变量的访问：
 *          对象.实例成员变量
 *  小结：
 *      静态成员变量有static修饰，属于类本身，与类加载一次，因为只有一份所以可以被类和类的对象访问
 *          注意，不建议用对象访问静态成员变量，静态成员变量直接用类名访问即可
 *      实例成员变量，无static修饰，属于类的对象的，必须先创建对象，然后用对象访问。
 */
public class Student {
    //0、实例成员变量；
    private String name;
    private int age;

    //1、静态方法，有static修饰，属于类，直接用类名访问即可；
    public static void inAddr(){
        System.out.println("我们都在学Java");
    }

    //2、实例方法，无static修饰，属于对象，必须用对象访问；
    public void eat(){
        System.out.println(name + "已经"+age+"岁");
    }

    public static void main(String[] args) {
        //a.类名.静态方法
        Student.inAddr();
        //注意，在同一个类中访问静态成员可以省略名称不写；

        //b.对象.实例方法
        //Student.eat();//报错
        Student zbj = new Student();
        zbj.name = "猪八戒";
        zbj.age = 50;
        zbj.eat();

        zbj.inAddr();//不推荐
    }
}
