package com.lchy._02线程池;

import java.util.concurrent.*;

/**
    目标：创建一个线程池

    线程池在Java中的代表类：ExecutorService(接口)

    Java在Executors类下提供了一个静态方法得到一个线程池的对象：
        1.public static ExecutorService newFixedThreadPool(int nThreads)
            创建一个线程池返回

    ExecutorService提交线程任务对象执行的方法：
        1.Future<?> submit(Runnable task):提交一个Runnable的任务对象给线程池执行。
        1.Future<?> submit(Callable task):提交一个Callable的任务对象给线程池执行。

 */
public class ThreadPoolsDemo03 {
    public static void main(String[] args) {
        //a.创建一个线程池，指定线程的固定数量是3
        ExecutorService pools = Executors.newFixedThreadPool(3);
        //b.添加线程任务让线程池处理
        Future<String> t1 = pools.submit(new MyCallable(100));//第1次提交任务，此时线程池创建新线程
        Future<String> t2 = pools.submit(new MyCallable(200));//第2次提交任务，此时线程池创建新线程
        Future<String> t3 = pools.submit(new MyCallable(300));//第3次提交任务，此时线程池创建新线程
        Future<String> t4 = pools.submit(new MyCallable(400));//第4次提交任务，复用之前的线程

        try {
            String rs1 = t1.get();
            String rs2 = t2.get();
            String rs3 = t3.get();
            String rs4 = t4.get();
            System.out.println(rs1);
            System.out.println(rs2);
            System.out.println(rs3);
            System.out.println(rs4);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //pools.shutdown();//等待任务执行完毕后才会关闭线程池
        //pools.shutdownNow();//立即关闭线程池代码，无论任务释放执行完毕
    }
}

class MyCallable implements Callable<String> {
    //需求：使用线程池，计算出1-100、1-200、1-300的和返回
    private int num;
    public MyCallable(){

    }
    public MyCallable(int num){
        this.num = num;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= num; i++) {
            sum += i;
            //System.out.println(Thread.currentThread().getName()+"===>"+i);
        }
        return Thread.currentThread().getName()+"执行的结果是===>"+sum;
    }
}
