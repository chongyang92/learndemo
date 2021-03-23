package com.lchy._06原子性;

/**
    目标：volatile修饰变量的原子性研究

    什么是原子性？
        原子性：是指一批操作是一个整体。要么同时成功，要么同时失败，不能被干扰。
            -500 +500
    volatile只能保证线程间变量的可见性，不能保证变量操作的原子性

    保证原子性的方案一
        加锁
    加锁机制性能较差
 */
public class VolatileAtomicDemo02 {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable02();
        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }
    }
}


class MyRunnable02 implements Runnable{
    private volatile int count;
    //一次任务是一个整体，加100
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                count++;
                System.out.println("count======>" + count);
            }
        }
    }
}