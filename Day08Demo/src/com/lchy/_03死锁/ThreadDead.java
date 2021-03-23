package com.lchy._03死锁;

/**
    目标：死锁

    死锁是这样一种情形：多个线程同时被阻塞，他们的其中一个或全部都在等待某个资源被释放。
        由于线程被无限期的阻塞，因此程序不可能正常终止

        客户（占用资金，等待经销商的货品资源）  经销商（占用货品资源，等待客户的资金）

    Java死锁产生的四个必要条件：
        1.互斥使用，即当资源被一个线程使用（占有）时，别的线程不能使用
        2.不可抢占，资源请求者不能强制从资源占有者手中夺取资源，资源只能由资源占有者主动释放
        3.请求和保持，即当资源请求者在请求其他的资源的同时保持对原有资源的占有
        4.循环等待，即存在一个等待循环队列：p1要的p2资源，p2要p1的资源，这样就形成了一个等待环

    当上述四个条件成立时，便形成死锁。当然死锁的情况下如果打破上述任何一个条件，便可让死锁消失

    代码实现（一个必然死锁的案例，面试需要）

    小结：
        死锁代码形式上通常需要进行锁的嵌套！
 */
public class ThreadDead {
    //定义一个资源对象
    public static Object resource01 = new Object();
    public static Object resource02 = new Object();

    public static void main(String[] args) {
        //定义两个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource01){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1占用资源1请求资源2");
                    synchronized (resource02){
                        System.out.println("线程1成功占用资源2");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource02){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2占用资源2请求资源1");
                    synchronized (resource01){
                        System.out.println("线程2成功占用资源1");
                    }
                }
            }
        }).start();
    }

}

