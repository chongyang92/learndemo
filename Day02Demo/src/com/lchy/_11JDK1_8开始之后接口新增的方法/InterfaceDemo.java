package com.lchy._11JDK1_8开始之后接口新增的方法;

/**
    JDK1.8之后接口新增了三个方法：
    （1）默认方法：其实就是我们之前写的实例方法。
            --必须用default修饰
            --默认会加public
            --只能用接口的实现类的对象来调用
    （2）静态方法：
            --可以直接加static修饰
            --默认会加public
            --接口的静态方法只能用接口的类名称本身调用，不能用实现类或实现类的对象调用
    （3）私有方法：（其实是从JDK1.9开始支持的）
            --其实就是私有的实例方法。必须加private修饰
            --私有的实例方法，只能在本接口中被访问
                私有的方法通常是给其他私有方法或者给默认方法调用的！
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        PingPongMan pingPongMan = new PingPongMan();
        pingPongMan.run();

        //接口的静态方法只能用接口名调用
        SportMan.inAddr();

    }
}

class PingPongMan implements SportMan{

}

interface SportMan{
    //1.默认方法，只能用接口的实现类的对象来调用
    public default void run(){
        go();//私有方法被默认方法调用
        System.out.println("跑的块");
    }

    //静态方法
    public static void inAddr(){
        System.out.println("住北京");
    }

    //私有方法通常是给私有方法或默认方法调用的！
    private void go(){
        go1();
    }
    private void go1(){
        System.out.println("开始");
    }
}
