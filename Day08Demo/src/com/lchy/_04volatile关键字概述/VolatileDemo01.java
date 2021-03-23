package com.lchy._04volatile关键字概述;

/**
    目标：并发编程下，多线程访问变量的不可见性问题。

    引入：
        多个线程访问共享变量，会出现一个线程修改变量的值后，其他线程看不到最新值的情况。
    结论：
        多线程编程下，多线程修改变量，会出现线程间变量的不可见性。
    不可见性的原因：
        每个线程都有自己的工作内存，线程都是从内存拷贝共享变量的副本值
        每个线程都是在自己的工作内存中操作共享变量的。
 */
public class VolatileDemo01 extends Thread{
    private  boolean flag = false;
    //private static boolean flag = false;//不管静态变量还是成员变量，值改变后都不可以被其他线程感知
    @Override
    public void run() {
        //模拟很多代码占用时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //在线程中修改代码
        flag = true;
        System.out.println("flag="+flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class VisiblityDemo{
    public static void main(String[] args) {
        //1.启动子线程，修改flag的变量为true
        VolatileDemo01 t = new VolatileDemo01();
        t.start();

        //2.主线程
        while (true){
            if(t.isFlag()){
                System.out.println("主线程进入执行");
            }
        }
    }
}
