package com.lchy._09文件上传演示;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyHandlerSocketThreadPool {
    private ExecutorService executorService;
    public MyHandlerSocketThreadPool(){
    }
    public MyHandlerSocketThreadPool(int corePoolSize,int maximumPoolSize){
        executorService = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                1000,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100)
        );
    }

    public void execute(Runnable task){
        this.executorService.execute(task);
    }
}
