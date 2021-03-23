package com.lchy._01线程通信;

import java.util.concurrent.locks.LockSupport;

/**
    目标：线程通信（了解原理，代码几乎不用）

    线程通信：多个线程因为在同一个进程中，所以相互通信比较容易

    线程通信的经典模型：生产者与消费者问题
        生产者负责生产商品，消费者负责消费商品
        生产不能过剩，消费不能没有

    模拟一个案例：
        小明和小红有一个共同账户：共享资源
        他们有3个爸爸(亲爸、岳父、干爹)给他们打钱

        模型：小明和小红去取钱，如果有钱就取出，然后等待自己，唤醒他们3个爸爸来存钱
            他们的爸爸来取钱，如果发现有钱就不存，没钱就存钱，然后等待自己，唤醒孩子每来取钱
            做整存整取：10000元

    分析：
        生产者线程：亲爸、岳父、干爹
        消费者线程：小明、小红
        共享资源：账户对象

    注意：线程通信一定是多个线程在操作同一个资源才需要进行通信
        线程通信必须先保证线程安全，否则毫无意义，代码也会报错！

    线程通信的核心方法：
        public void wait():让当前线程进入到等待状态 此方法必须锁对象调用
 */
public class ThreadCommunication {
    public static void main(String[] args) {
        //1.创建一个共享账户
        Account account = new Account("10101",0);

        //2.创建两个线程对象代表小明和小红
        new DrawThread(account,"小明").start();
        new DrawThread(account,"小红").start();

        new SaveThread(account,"亲爹").start();
        new SaveThread(account,"岳父").start();
        new SaveThread(account,"干爹").start();

    }
}

enum State {
    NEW,
    RUNNABLE,
    BLOCKED,
    WAITING,
    TIMED_WAITING,
    TERMINATED;
}