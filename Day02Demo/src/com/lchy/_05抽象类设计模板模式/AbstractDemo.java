package com.lchy._05抽象类设计模板模式;

/**
    目标：抽象类设计模板设计模式；

    什么是设计模式？
        设计模式：前人或者技术大牛，在实战中发现的优秀设计架构和思想
        后来者可以直接用这些框架或者思想就可以设计出优秀，并且提高开发效率，可扩展性，可以维护性的软件。

    模板设计模式就是一种经典的设计模式思想；

    模板设计模式的作用，优化代码架构，提高代码复用性，相同功能的重复代码无需反复书写
        可以做到部分实现，部分抽象，抽象的东西交给使用模板的人重新实现。

    作文模块：
        标题固定《我的爸爸》
        第一段固定：请介绍一下你的爸爸。
        正文部分： 抽象出来
        结尾部分： 我爸爸真棒。
 */
public class AbstractDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.write();
    }

}

class Student extends Template{
    @Override
    public String writeMain() {
        return "\t\t\t很好很好很好很好很好很好很好很好很好很好很好很好";
    }
}

//1、设计模板类
abstract class Template{
    private String title = "\t\t\t\t《我的爸爸》";
    private String one = "\t\t\t请介绍一下你的爸爸";
    private String last = "\t\t\t我爸爸真棒";

    //2、写作文的功能
    public void write(){
        System.out.println(title);
        System.out.println(one);

        //3、正文部分，正文部分不能确定，交给使用模板的子类来写
        System.out.println(writeMain());

        System.out.println(last);
    }

    public abstract String writeMain();
}