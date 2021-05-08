package com.lchy._12面试题;

import java.util.ArrayList;

public class Test02 {
    private static int COUNT = 0;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        Test02 test = new Test02();
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
            if(i == 3 || i == 5){
                continue;
            }
            threads.get(i).join();
        }
        System.out.println("spend time:" + (System.currentTimeMillis() - start) + "ms");
    }

    public void test1() throws InterruptedException {
        System.out.println("线程启动顺序"+Thread.currentThread().getName());
        int x = 0;
        for (int i = 0; i < 100; i++) {
            x = x + 1;
            Thread.sleep(1);
        }
        for (int i = 0; i < 10000000; i++) {
            COUNT++;
        }
        System.out.println("线程结束顺序："+Thread.currentThread().getName()+" count:"+COUNT);
    }

    public void test2() throws InterruptedException {

        int x = 0;
        for (int i = 0; i < 100; i++) {
            x = x + 1;
            Thread.sleep(1);
        }
        System.out.println("线程启动顺序"+Thread.currentThread().getName()+" count:"+COUNT);
        //synchronized (this) {
            for (int i = 0; i < 10000000; i++) {
                COUNT++;
            }
        //}
        System.out.println("线程结束顺序："+Thread.currentThread().getName()+" count:"+COUNT);
    }

}

