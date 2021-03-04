package com.lchy._11继承后_方法重写;

/**
 * 目标：super调用父类被重写的方法
 *
 * super：代表了父类引用
 */
public class ExtendsDemo02 {
    public static void main(String[] args) {
        SportMan sportMan = new SportMan();
        sportMan.run();
        sportMan.go();
    }

}

class SportMan extends People{
    @Override
    public void run() {
        System.out.println("运动员跑的快");
    }
    //方法中转
    public void go(){
        super.run();
        run();
    }
}

class People{
    public void run(){
        System.out.println("人会跑");
    }
}
