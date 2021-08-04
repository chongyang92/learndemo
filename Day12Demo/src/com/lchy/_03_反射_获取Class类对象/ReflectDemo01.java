package com.lchy._03_反射_获取Class类对象;

import java.lang.reflect.InvocationTargetException;

/**
    目标：反射获取Class类对象。

    引入：
        反射是通过先得到编译后的Class类对象：字节码.class文件。
        然后才可以得到类中的全部成分，进行一些功能设计。

    反射为一个类的全部成分都设计了一个类型来代表这个对象：
        Class：字节码文件的类型
        Constructor：构造器的类型
        Field：成员变量的类型
        Method：方法的类型

    反射技术的第一步永远是先得到Class类对象：有三种方式获取
        （1）类名.class
        （2）类的对象.getClass()方法
        （3）Class.forName("类的全路径名")
                -- public static Class<?> forName(String className)

    小结：
        Class类对象的获取有三种方式：没有好坏，适合就好
            1.类名.class                      //一般用Class <?> aClass去接
            2.通过类的对象.getClass()方法。
            3.Class.forName(“类的全限名”)     //全路径限制    com.lchy._03_反射_获取Class类对象.Student

        Class类的方法：
            String getSimpleName(); 获得名字字符串；类名
            String getName(); 获得类全名：包名+类名
 */
public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //反射的第一步永远是先得到类的class文件对象：字节码文件。
        //1.类名.class
        Class<Student> c1 = Student.class;//这里的<Student>一般写成<?>
        System.out.println(c1);

        //2.对象.getClass()
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();
        System.out.println(aClass);
        
        //3.Class.forName("类的全限名")
        Class c3 = Class.forName("com.lchy._03_反射_获取Class类对象.Student");
        System.out.println(c3);

        System.out.println(c1.getSimpleName());//获取类名本身(简名)
        System.out.println(c1.getName());//获取类的全限名
        //Student s1 = c1.newInstance();//调用无参构造器得到对象，被淘汰
        Student student1 = c1.getConstructor().newInstance();//使用这个获取对象
    }
}
