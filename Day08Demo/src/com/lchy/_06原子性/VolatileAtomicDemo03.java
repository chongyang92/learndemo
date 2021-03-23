package com.lchy._06原子性;

import java.util.concurrent.atomic.AtomicInteger;

/**
    目标：volatile修饰变量的原子性研究

    什么是原子性？
        原子性：是指一批操作是一个整体。要么同时成功，要么同时失败，不能被干扰。
            -500 +500
    volatile只能保证线程间变量的可见性，不能保证变量操作的原子性

    保证原子性的方案一
        加锁
    枷锁机制性能较差

    方案二：使用原子类，性能高效，线程安全。
    概述：Java从jdk1.5开始提供了java.util.concurrent.atomic简称Atomic包
        这个包中的原子操作类提供了一种用法简单、性能高效、线程安全地更新一个变量的方式。

    AtomicInteger
        原子型

    小结：
        可以使用原子类保证原子性操作，从而实现线程安全
        加锁机制的性能较差
        为什么使用原子类可以保证原子性操作，且性能好，而且线程安全呢？

 */
public class VolatileAtomicDemo03 {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable03();
        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }
    }
}


class MyRunnable03 implements Runnable{
    //创建一个Integer更新的原子类AtomicInteger,初始值0
    private AtomicInteger atomicInteger = new AtomicInteger();
    //private volatile int count;//这个count没用了，被atomicInteger替代了
    //一次任务是一个整体，加100
    @Override
    public void run() {
        //synchronized (this) {
            for (int i = 0; i < 100; i++) {
                //count++;
                System.out.println("count======>" + atomicInteger.incrementAndGet());
            }
        //}
    }
}