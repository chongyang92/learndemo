package com.lchy._10接口与接口的多继承;

/**
    目标： 接口与接口的多继承

    引入：
        类与类是单继承关系： 一个类只能继承一个直接父类
        类与接口是多实现关系：一个类可以同时实现多个接口
        接口与接口是多继承关系：一个接口可以同时继承多个接口
    总结：
        语法，记住
 */
public class InterfaceDemo {
}
//接口与接口的多继承，用一个接口合并多个接口
class PingPongMan implements SportMan {
    @Override
    public void run() {

    }

    @Override
    public void competition() {

    }

    @Override
    public void rule() {

    }

    @Override
    public void abroad() {

    }
}

interface SportMan extends Law,Go{
    void run();
    void competition();
}

interface Law{
    void rule();
}

interface Go{
    void abroad();
}