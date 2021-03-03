package com.lchy._14final关键字;

/**
    了解：final修饰变量——局部变量

    final修饰变量的总规则：有且仅能被赋值一次

    变量有几种？
        成员变量：
            --静态成员变量：有static修饰，属于类，只加载一次
            --实例成员变量：无static修饰，属于每个对象，与对象一起加载
        局部变量
            --只能存在方法中，构造器中，代码块中，for循环中，作用范围是代码块，用完就消失
    final修饰局部变量：
            --让值被固定或者说保护起来，执行过程中防止被修改。
 */
public class FinalDemo02 {
    public static void main(String[] args) {
        /*final 修饰局部变量*/
        final int age = 10;
        //age = 100;//报错，只能赋值一次，这是第二次赋值了

        final double rate = 3.14;

        buy(0.8);
        buy(0.9);
        /*final 修饰局部变量*/
    }

    public static void buy(final double rate){
        //rate = 0.1;//报错，第二次赋值了
    }
}
