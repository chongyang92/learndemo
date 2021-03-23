package com.lchy._05变量不可见性解决;

/**
    目标：并发编程下，多线程访问变量的不可见性解决方案。

    引入：
        多个线程访问共享变量，会出现一个线程修改变量的值后，其他线程看不到最新值的情况。
    现象：
        多线程编程下，多线程修改变量，会出现线程间变量的不可见性。
    不可见性的原因：
        每个线程都有自己的工作内存，线程都是从内存拷贝共享变量的副本值
        每个线程都是在自己的工作内存中操作共享变量的。

    解决方案有两种常见方式：
        1.加锁
        2.对共享的变量进行volatitle关键字修饰

    1.synchronized加锁前后，执行过程如下
        a.线程获得锁
        b.清空工作内存
        c.从主内存拷贝共享变量最新的值到工作内存成为副本
        d.执行代码
        e.将修改后的副本的值刷新回主内存中
        f.线程释放锁

    2.对共享的变量进行volatitle关键字修饰
        a.volatile修饰的变量可以在多线程并发修改下，实现线程间变量的可见性
        b.一旦一个线程修改了volatile修饰的变量，另一个线程可以立即收取到最新值

    volatile和synchronized区别
        volatile只能修饰实例变量和类变量，而synchronized可以修饰方法及代码块
        volatile保证数据可见性，但是不保证原子性（多线程进行写操作，不保证线程安全）
            而synchronized是一种排他（互斥）的机制。
 */
public class VolatileDemo01 extends Thread{
    //private volatile boolean flag = false;//可以加关键字，只能保证数据可见性，不能保证原子性
    private boolean flag = false;
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
            //加锁会清空工作内存，读取主内存中最新值到工作内存中
            synchronized (VisiblityDemo.class){//静态方法中，用类名.class
               if(t.isFlag()){
                   System.out.println("主线程进入执行");
               }
           }
        }
    }
}
