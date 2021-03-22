package com.lchy._14线程的常用API;

/**
    目标：线程的常用API

    Thread类的API：
        1.public void setName(String name):给当前线程取名字
        2.public void getName():获取当前线程的名字
            --线程存在默认名称，子线程的默认名称是： Thread-索引。
            --主线程的默认名称就是：main
        3.public static Thread currentThread()
            --获取当前线程对象，这个代码在哪个线程中，就得到哪个线程对象。
 */
public class ThreadDemo {
    //启动后的ThreadDemo当成一个进程
    //main方法是由主线程执行的，理解成main方法就是一个主线程
    public static void main(String[] args) {
        //3.创建一个线程对象
        Thread t = new MyThread();
        //4.调用线程对象的start()方法启动线程，最终还是执行run()方法
        //如果线程直接调用run()方法，相当于变成了普通类的执行，此时将只有主线程在执行他们
        //t.run();
        t.start();
        t.setName("线程1：");

        Thread t1 = new MyThread();
        System.out.println(t1.getName());
        t1.setName("线程2：");
        t1.start();


        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            System.out.println("main线程输出：" + i);
        }
    }
}

//1.定义一个线程类继承Thread类//就像学生类一样，是个类，没有创建线程对象
class MyThread extends Thread{
    //2.重写run()方法
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + "子线程输出：" + i );
        }
    }
}