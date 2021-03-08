package com.lchy._07内部类_静态内部类;

import java.util.Map;

/**
    目标：静态内部类

    什么是静态内部类？
        有static修饰，属于外部类本身，会加载一次。
    静态内部类中的成份研究：
        类有的成份它都有，静态内部类属于外部类本身，只会加载一次。
        所以它的特点与外部类完全一样，只是位置在别人里面而已。

        外部类=宿主     汽车
        内部类=寄生     发动机
    静态内部类访问格式：
        外部类名称.内部类名称

    静态内部类创建对象：
        外部类名.内部类名 name = new 外部类名.内部类构造器;

    静态内部类访问拓展：
        静态内部类中是否可以直接访问外部类的静态成员变量？可以的，外部静态成员只有一份，可以被共享
        静态内部类中是否可以直接访问外部类实例成员，不可以，外部类的成员必须用外部类对象访问，可以在内部类创建外部类对象。

    小结：
        静态内部类属于外部类本身，只会加载一次
        所以它的特点与外部类是完全一样的，只是位置在别人里面而已
 */
public class InnerClass {
    public static void main(String[] args) {
        Outter.Inner inner = new Outter.Inner();
        inner.setName("张三");
        inner.setAge(29);
        System.out.println(inner.getAge());
        System.out.println(inner.getName());
        inner.show();
    }

}

class Outter{


    public static String address = "北京";

    //静态内部类，有static修饰，属于外部类，只会加载一次
    public static class Inner{
        private String name;
        private int age;
        public static String schoolName = "大学";

        public Inner() {
        }

        public Inner(String name, int age) {
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

        public void show(){
            System.out.println(address);//可以直接访问外部类静态成员变量
        }
    }


    static interface StaticIn{}//内部接口，不管有没有static修饰，都是静态的
    static abstract class AbstractClass{ }
}