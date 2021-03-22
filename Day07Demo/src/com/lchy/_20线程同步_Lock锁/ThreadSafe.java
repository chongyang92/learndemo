package com.lchy._20线程同步_Lock锁;

/**
    目标：线程同步_同步代码块

    线程同步的作用：就是为了解决线程安全问题的方案。

    线程同步解决线程安全问题的核心思想：
        让多个线程实现先后依次访问共享资源，这样就解决了安全问题

    线程同步的做法：
        是把共享资源进行上锁，每次只能一个线程进入访问完毕以后，其他线程才能进来。

    线程同步的方式有三种：
        （1）同步代码块
        （2）同步方法
        （3）lock显示锁

    a.同步代码块
        作用:把出现线程安全问题的核心代码给上锁，每次只能一个线程进入
            执行完毕以后自动解锁，其他线程才可以进来执行

        格式：
            synchronized(锁对象){
                //访问共享资源的核心代码
            }
            锁对象：理论上可以是任意的”唯一“对象即可。
            原则上：锁对象建议使用共享资源
                --在实例方法中建议用this作为锁对象，此时this正好是共享资源！
                --在静态方法中建议用类名.class字节码作为锁对象。

    b.同步方法
        作用：把出现线程安全问题的核心方法给锁起来
            每次只能一个线程进入访问，其他线程必须在方法外等待
        用法：直接给方法加上一个修饰符 synchronized
            同步方法是把整个方法的代码都锁起来
            同步方法其实底层也是有锁对象的
                如果方法是实例方法：同步方法默认用this作为的锁对象
                如果方法是静态方法：同步方法默认用类名.class作为锁对象
    c.lock显示锁
        java.util.concurrent.locks.Lock机制提供了比synchronized代码块和synchronized方法锁
        同步代码块/同步方法具有的功能Lock都有，除此之外更强大

        Lock锁也称同步锁，加锁与释放锁方法化了，如下：
            -public void lock() :加同步锁
            -public void unlock():释放同步锁
 */
public class ThreadSafe {
    public static void main(String[] args) {
        //a.创建一个共享资源账户对象！
        Account acc = new Account("1212",100000);

        //b.创建2个线程对象去账户对象中取钱
        Thread ming = new DrawThread(acc,"小明");
        ming.start();

        Thread hong = new DrawThread(acc,"小红");
        hong.start();
    }
}
