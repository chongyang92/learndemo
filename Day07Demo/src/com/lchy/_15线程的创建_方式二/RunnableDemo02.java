package com.lchy._15线程的创建_方式二;

/**
    目标：方式二的匿名内部类写法，简化写法。
 */
public class RunnableDemo02 {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()+i);
                }
            }
        }, "1号线程").start();//这个Thread类，是实现了Runnable接口的，并且做好了很多关于线程用到的操作内容


        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}

