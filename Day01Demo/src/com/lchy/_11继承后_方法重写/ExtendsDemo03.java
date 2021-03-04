package com.lchy._11继承后_方法重写;

/**
 * 目标：静态方法和私有方法是否可以被重写（拓展语法）
 * 可以吗？   都不可以
 */
public class ExtendsDemo03 {
}

class Mac extends Computer{
    //@Override //不可以重新父类私有方法
    public void run() {

    }
    //@Override   //不可以重写父类静态方法
    public static void test(){

    }
}

class Computer{
    private void run() {

    }
    public static void test(){

    }
}
