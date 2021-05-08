package com.lchy._07并发包ConcurrentHashMap;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
    目标：并发包的介绍（面试重点中的重点）

    并发包的来历：
        在实际开发中如果不需要考虑线程安全问题，大家不需要做线程安全，因为如果做了反而性能不好！
        但是开发中有很多业务是需要考虑线程安全问题的，此时就必须考虑了，否则业务出现问题。
        Java为很多业务场景提供了性能优异，且线程安全的并发包，程序员可以选择使用！

    Map集合中的经典集合：HashMap他是“线程不安全”的，性能好
        --如果在要求线程安全的业务情况下，就不能用这个集合做Map集合，否则业务会崩溃
    为了保证线程安全，可以使用hashtable，注意：线程中加入了计时
        --Hashtable是线程安全的Map集合，但是性能较差（已经淘汰了，虽然安全，但是性能差）
    为了保证线程安全，再看ConcurrentHashMap(不止线程安全，而且效率高，性能好，最新最好用的线程安全类)
        --ConcurrentHashMap保证了线程安全，综合性能较好！

    小结：
        HashMap它是线程不安全性能好
        HashTable锁整个集合，线程安全，性能较差！被淘汰
        ConcurrentHashMap锁一个局部链，线程安全，性能好。分段式锁，只锁自己操作的元素位置
 */
public class ConcurrentHashMapDemo {
    //需求：演示HashMap在高并发下的线程不安全性
    //public static Map<String,String> maps = new HashMap<>();
    //public static Map<String,String> maps = new Hashtable<>();//所有方法都用synchronized加锁
    public static Map<String,String> maps = new ConcurrentHashMap<>();//线程安全，性能得到了极大提升

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable,"线程1");
        Thread t2 = new Thread(runnable,"线程2");
        Thread t3 = new Thread(runnable,"线程3");
        Thread t4 = new Thread(runnable,"线程4");
        Thread t5 = new Thread(runnable,"线程5");
        Thread t6 = new Thread(runnable,"线程6");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        try {
            //主线程会抢t1和t2的CPU，但是都不能抢，t1和t2之间是可以相互抢的
            t1.join();//让t1跑完，join方法应该想到，康熙、雍正、乾隆，先让康熙当完皇帝，用在才能即位
            t2.join();//让t2跑完
//            t3.join();
            t4.join();
            //t5.join();
            t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //等待两个线程完毕后获取集合最终的元素个数
        System.out.println("元素个数："+maps.size());
    }
}

class MyRunnable implements Runnable{
    AtomicLong count = new AtomicLong(0);
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            ConcurrentHashMapDemo.maps.put(Thread.currentThread().getName()+i,Thread.currentThread().getName()+i);
            count.incrementAndGet();
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"结果"+count+"耗时"+(end-start)+"ms");
    }
}
