package com.lchy._08内部类实例内部类;

import javax.print.attribute.standard.MediaSize;

/**
    目标：实例内部类：外部类——人，内部类——眼睛

    什么是实例内部类？
        无static修饰的内部类，属于外部类的每个对象，跟着对象一起加载。

    格式：


    实例内部类的成份特点：
        实例内部类中不能定义静态变量和静态方法
        可以定义常量，static final

    实例内部类访问格式：
        外部类名称.内部类名称

    创建对象的格式：
        外部类名.内部类名 对象名 = new 外部类构造器.new 内部类构造器

    拓展：
        实例内部类是否可以直接访问外部类静态成员？可以，外部类的静态成员被共享访问
        实例内部类是否可以直接访问外部类实例成员？可以，实例内部类属于外部类对象，

    小结：
        实例内部类属于外部类对象，需要用外部类对象一起加载。
        实例内部类可以访问外部类的全部成员！
 */
public class InnerClass {
    public static void main(String[] args) {
        Outter.Inner inner = new Outter().new Inner();
        inner.show();
    }
}

//外部类
class Outter{

    public static int age = 29;

    private double salary = 20000;

    //实例内部类：无static修饰，属于外部类对象
    public class Inner{
        private String name;

        /*不能在实例内部类中定义静态成员*/
        //public static String schoolName = "大学";
        //public static test(){}

        //可以定义常量
        public static final String address = "北京";

        public void show(){
            System.out.println(age);
            System.out.println(address);
            System.out.println(salary);
        }
    }
    interface AA{

    }
}