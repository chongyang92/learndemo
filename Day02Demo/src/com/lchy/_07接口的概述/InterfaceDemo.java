package com.lchy._07接口的概述;

import java.io.Reader;

/**
    目标：接口的概述（认识接口）

    什么是接口？
        接口是更加彻底的抽象，在jdk1.8之前接口中只能是抽象方法和常量。
        接口体现的是规范思想，实现接口的子类必须重写完接口的全部抽象方法。

    接口定义格式(关注语法)
        修饰符 interface 接口名称{
            //在jdk1.8之前接口中只能是抽象方法和常量
        }
        interface定义接口的核心关键字。

    接口中成份研究：
        在jdk1.8之前接口中只能是抽象方法和常量

    小结：
        接口体现的是规范思想。
        jdk1.8之前只有抽象方法和常量！
        接口中抽象方法的 public abstract 可以不写，默认会加上
        接口中常量的    public static final 可以不写，默认会加上
        没有普通成员变量、构造方法、普通方法
        jdk1.8之后，才有static和default方法
 */
public interface InterfaceDemo {
    //1、抽象方法。
    //接口中的抽象方法可以省略public abstract 不写，会默认加上！
    public abstract void run();

    //2、常量：变量值只有一个，而且在程序运行过程中，不可更改！
    //常量一般修饰符是public static final.
    //常量的变量名称建议字母全部大写，多个单词用“_”连接！
    public static final String SCHOOL_NAME = "黑马";

    default void show(){}

    static void test(){}

    //private String name;

    //public InterfaceDemo(){}
}

abstract class  A implements InterfaceDemo{

}