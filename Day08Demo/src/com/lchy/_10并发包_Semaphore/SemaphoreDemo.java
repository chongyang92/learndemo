package com.lchy._10并发包_Semaphore;

import java.util.concurrent.Semaphore;

/**
    引入：
     Semaphore（发信号）的主要作用是控制线程的并发占锁的数量。

     synchronized可以起到"锁"的作用，但某个时间段内，只能有一个线程允许执行。

     Semaphore可以设置同时允许几个线程执行。

     Semaphore字面意思是信号量的意思，它的作用是控制访问特定资源的线程数目。

 Semaphore构造方法：
    public Semaphore(int permits)	permits 表示许可线程的数量
    public Semaphore(int permits, boolean fair)	fair 表示公平性，如果这个设为 true 的话，下次执行的线程会是等待最久的线程

 Semaphore重要方法：
    public void acquire() throws InterruptedException	表示获取许可
    public void release()

 小结：
    Semaphore 可以控制线程并发占锁的数量

 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Serivce serivce = new Serivce();
        for (int i = 0; i < 5; i++) {
            Thread t = new MyThread(serivce);
            t.start();
        }
    }
}

class MyThread extends Thread{
    private Serivce serivce;
    public MyThread(Serivce serivce){
        this.serivce = serivce;
    }
    @Override
    public void run() {
        serivce.login();
    }
}

//也是代码
class Serivce{
    private Semaphore semaphore = new Semaphore(2);
    //登陆
    public void login(){
        try {
        semaphore.acquire();
        System.out.println(Thread.currentThread().getName()
                + " 进入 时间=" + System.currentTimeMillis());

            Thread.sleep(1000);

        System.out.println(Thread.currentThread().getName()
                + "   结束 时间=" + System.currentTimeMillis());
        semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
