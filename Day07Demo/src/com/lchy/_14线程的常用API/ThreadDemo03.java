package com.lchy._14线程的常用API;

/**
    目标：通过Thread类的有参数构造器为当前线程对象取名字
        --public Thread()
        --public Thread(String name):创建线程对象并取名字


 */
public class ThreadDemo03 {
    //启动后的ThreadDemo当成一个进程
    //main方法是由主线程执行的，理解成main方法就是一个主线程
    public static void main(String[] args) {
        //3.创建一个线程对象
        Thread t = new MyThread02("线程1：");
        //4.调用线程对象的start()方法启动线程，最终还是执行run()方法
        //如果线程直接调用run()方法，相当于变成了普通类的执行，此时将只有主线程在执行他们
        //t.run();
        t.start();
        //t.setName("线程1：");

        Thread t1 = new MyThread02("线程2：");
        System.out.println(t1.getName());
        //t1.setName("线程2：");
        t1.start();


        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            System.out.println("main线程输出：" + i);
        }
    }
}

//1.定义一个线程类继承Thread类//就像学生类一样，是个类，没有创建线程对象
class MyThread02 extends Thread{
    public MyThread02(String name){
        //调用父类有参构造器，初始化当前线程名称
        super(name);
    }
    //2.重写run()方法
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + "子线程输出：" + i );
        }
    }
}