package com.lchy._04异常的产生处理的默认过程;

/**
    目标：异常的产生默认的处理过程解析。（自动处理的过程）
        （1）默认会在出现异常的代码那里自动的创建一个异常对象：ArithmeticException
        （2）异常会从方法中出现的点这里抛出给调用者，调用者最终抛出给JVM虚拟机
        （3）虚拟机接收到异常对象后，先在控制台直接输出异常栈信息数据
        （4）直接从当前执行的异常点干掉当前程序
        （5）后续代码没有机会执行了，因为程序已经死亡。

 */
public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("程序开始。。。");
        chu(10,0);
        System.out.println("程序结束。。。");
    }

    private static void chu(int a, int b) {
        System.out.println(a);
        System.out.println(b);
        int c = a / b; //出现了运行时异常，自动创建异常对象:AtithmeticException
        System.out.println("结果是："+c);
    }
}
