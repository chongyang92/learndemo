package com.lchy._12面试题;

import java.util.ArrayList;

public class Test01 {
    private static int COUNT = 0;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        Test01 test = new Test01();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
//                    test.test1();
                    test.test2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads.add(thread);
            //System.out.println("加入顺序："+thread.getName());
            thread.start();
        }
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).join();
        }
        System.out.println("spend time:" + (System.currentTimeMillis() - start) + "ms");
    }

    public synchronized void test1() throws InterruptedException {
        System.out.println("启动顺序"+Thread.currentThread().getName());
        int x = 0;
        for (int i = 0; i < 100; i++) {
            x = x + 1;
            Thread.sleep(1);
        }
        for (int i = 0; i < 10000000; i++) {
            COUNT++;
        }
        System.out.println("结束顺序："+Thread.currentThread().getName());
    }

    public void test2() throws InterruptedException {
        System.out.println("启动顺序"+Thread.currentThread().getName());
        int x = 0;
        for (int i = 0; i < 100; i++) {
            x = x + 1;
            Thread.sleep(1);
        }

        synchronized (this) {
            for (int i = 0; i < 10000000; i++) {
                COUNT++;
            }
        }
        System.out.println("结束顺序："+Thread.currentThread().getName());
    }
}

