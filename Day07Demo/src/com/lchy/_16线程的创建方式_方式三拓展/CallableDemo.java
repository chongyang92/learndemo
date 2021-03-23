package com.lchy._16线程的创建方式_方式三拓展;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
    目标：实现Callable接口。

    c.线程的创建方式三：实现Callable 接口
        --1.定义一个线程任务类实现Callable接口，申明线程执行的结果类型
        --2.重写线程任务类的call方法，这个方法可以直接返回执行的结果。
        --3.创建一个Callable的线程任务对象
        --4.把Callable的线程任务对象包装成一个未来任务对象
        --5.把未来任务对象包装成线程对象
        --6.调用线程的start()方法启动线程
    优缺点：
        优点：全是优点；
            --线程任务类只是实现了Callable接口，可以继续继承其他类，同时可以继续实现其他
            --一个线程任务对象可以被共享成多个线程对象。适合做多线程的资源共享操作。
            --很适合做线程池的执行任务。
            --可以直接获取线程执行的结果。
        缺点：编码复杂。
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //3.创建一个Callable的线程任务对象
        Callable callable = new MyCallable();
        //4.把Callable任务对象包装成一个未来任务对象
        //public FutureTask(Callable<V> callable)
        //未来任务对象是啥，有啥用？
        //    未来任务对象其实就是一个Runnable对象:这样就可以被包装成线程对象!
        //    未来任务对象可以在线程执行完毕之后去得到线程执行的结果。
        FutureTask<String> task = new FutureTask<>(callable);
        Thread t = new Thread(task);
        //6.启动线程对象
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }

        //当取结果时，线程虽然已经启动，但不一定执行完成，此处取结果时，会
        //把CPU让出，等待线程执行完成再来取结果，所以最终一定会得到结果
        String s = task.get();//会抛异常ExecutionException
        System.out.println(s);

        //new Thread(callable);//没有直接提供这个方法
    }
}


//1.创建一个线程任务类实现Callable接口，申明线程返回的结果类型
class MyCallable implements Callable<String>{
    //2.重写线程任务类的call方法！
    @Override
    public String call() throws Exception {
        //需求：计算1-10的和，并返回
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() + String.valueOf(sum);
    }
}