package com.lchy._07TCP通信四;

import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
    目标：处理socket连接的线程池
 */
public class HandlerSocketThreadPool {
    //线程池:3个线程，100个任务
    private ExecutorService executorService;
    public HandlerSocketThreadPool(int maxPoolSize, int queueSize){
        this.executorService = new ThreadPoolExecutor(
                maxPoolSize,
                maxPoolSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));

    }

    public void execute(Runnable task){
        this.executorService.execute(task);
    }


}
