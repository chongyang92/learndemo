package com.lchy._09装饰设计模式;


/**
    目标：装饰模式。

    装饰模式指的是在不改变原类，不使用继承的基础上，动态地扩展一个类的功能。
    思想：是创建一个新类，包装原始类，从而在新类中提升原来类的功能！
    小结：
        装饰模式可以在不改变原类的基础上对类中的方法进行扩展增强，实现原则为：
        1.定义父类。(抽象类)
        2.定义原始类，继承父类(抽象类)，定义功能。
        3.定义装饰类，继承父类(抽象类)，包装原始类，增强功能！!
 */
public class Demo {
    public static void main(String[] args) {
        InputStream inputStream = new FileInputStream();
        inputStream.read();

        InputStream inputStream1 = new BufferedInputStream(new FileInputStream());
        inputStream1.read();
        inputStream1.close();
    }
}
