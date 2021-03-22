package com.lchy._15线程的创建_方式二;

/**
    目标：线程创建方式二。

     多线程是很有用的，我们在进程中创建线程的方式有三种：
     （1）直接定义一个类继承线程类，重写run()方法，创建线程对象
     调用线程对象的start()方法启动线程
     （2）定义一个线程任务类实现Runnable接口，重写run()方法，创建线程任务对象，
     把线程任务对象包装成线程对象，调用线程对象的start()方法启动线程。
     （3）实现Callable接口(拓展)

    b.实现Runnable接口
        --1.创建一个线程任务类实现Runnable接口
        --2.重写run()方法
        --3.创建一个线程任务对象
        --4.把线程任务对象包装成线程对象
        --5.调用线程对象的start()方法启动线程。

    Thread构造器：
        --public Thread(){}
        --public Thread(String name){}
        --public Thread(Runnable target){}
        --public Thread(Runnable target, String name){}

    实现Runnable接口创建线程的优缺点：
        缺点：代码复杂一点
            不能得到线程的结果
        有点：
            --线程任务类只是实现了Runnable接口，可以继续继承其他类，而且可以继续实现其他类
            --同一个任务对象可以被包装成多个线程对象
            --适合多个相同的程序代码的线程去共享同一个资源
            --实现解耦操作，线程任务代码可以被多个线程共享，线程任务代码和线程独立。
            --线程池可以放入实现Runnable或Callable线程任务对象
                注意：其实Thread类本身也是实现了Runnable接口的。
 */
public class RunnableDemo {
    public static void main(String[] args) {
        //MyRunnable myRunnable = new MyRunnable();
        Runnable myRunnable = new MyRunnable();//要使用接口多态
        Thread t1 = new Thread(myRunnable,"1号线程");
        t1.start();//这个Thread类，是实现了Runnable接口的，并且做好了很多关于线程用到的操作内容
        //如果有另一个新的线程类，可以只实现Runnable接口中的run()方法，其他功能、属性使用Thread已经定义好的
        //myRunnable.run();


        Thread t2 = new Thread(myRunnable,"2号线程");//同一个线程任务对象可以
        t2.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}

//MyRunnable是线程任务类，Thread是线程类
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
