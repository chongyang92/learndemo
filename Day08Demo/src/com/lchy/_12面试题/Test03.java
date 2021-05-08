package com.lchy._12面试题;

/**
    目标：join()的真正作用

    有四线程，main线程、子线程1、子线程2、子线程2的子线程C
 */
public class Test03 {
    public static void main(String []args) throws InterruptedException{

        TestB t1 = new TestB("子线程1");
        TestB t2 = new TestB("子线程2");
        t1.start();
        //子线程先调用start()，在CPU注册一下
        t2.start();
        //然后，在子线程2的队列中，加入main线程中，子线程t2结束后，会主动唤醒主线程，这里和t1没有关系，t1从开始到结束不受主线程和t2的影响
        t2.join();//join()方法源码会调用wait()方法，即使本代码(t2.join())所在线程(main线程)进入无限等待，什么时候会被唤醒呢，在
        
        System.out.println("我是主线程，我要执行完啦");

    }
}

class TestC extends Thread {

    public TestC() {

    }

    public TestC(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1);
                /*if (getName().equals("子线程1")) {
                    join();
                }*/
                //wait();
                System.out.println("我是" + getName());
            }
        } catch (InterruptedException e) {
                e.printStackTrace();
        }

    }
}

class TestB extends Thread {

    public TestB() {

    }

    public TestB(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {

                if (getName().equals("子线程2")) {
                    //Thread.sleep(1000);
                    TestC tc = new TestC(getName()+"的子线程C");
                    tc.start();
                    tc.join();
                }


                System.out.println("我是" + getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public final synchronized void join2(long millis)
            throws InterruptedException {
        long base = System.currentTimeMillis();
        long now = 0;

        if (millis < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }

        if (millis == 0) {
            //看看执行join()的时候，当前线程是谁
            System.out.println("我是"+Thread.currentThread().getName()+"我在执行join2()");
            System.out.println(this.getName());
            while (isAlive()) {
                this.wait(0);
            }
        } else {
            System.out.println("我是"+Thread.currentThread().getName());
            while (isAlive()) {
                long delay = millis - now;
                if (delay <= 0) {
                    break;
                }
                this.wait(delay);
                now = System.currentTimeMillis() - base;
            }
        }
    }
}
