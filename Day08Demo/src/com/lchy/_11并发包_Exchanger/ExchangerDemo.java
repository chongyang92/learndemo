package com.lchy._11并发包_Exchanger;

import java.util.concurrent.Exchanger;

/**
    目标：Exchange
    Exchanger（交换者）是一个用于线程间协作的工具类。Exchanger用于进行线程间的数据交换。

    这两个线程通过exchange方法交换数据，如果第一个线程先执行exchange()方法，它会一直等待第二个线程也执行exchange方法，当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产出来的数据传递给对方。

    Exchanger构造方法：
        public Exchanger()
    Exchanger重要方法：
        public V exchange(V x)
    分析：
        （1）需要2个线程
        （2）需要一个交换对象负责交换两个线程执行的结果。
    小结：
        Exchanger可以实现线程间的数据交换
        一个线程如果等不到对方的数据交换就会一直等待
        我们也可以控制一个线程等待的时间
        必须双方都进行交换才可以正常进行数据的交换

     使用场景：可以做数据校对工作

     需求：比如我们需要将纸制银行流水通过人工的方式录入成电子银行流水。为了避免错误，采用AB岗两人进行录入，录入到两个文件中，系统需要加载这两个文件，

     并对两个文件数据进行校对，看看是否录入一致，
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Boy(exchanger).start();
        new Girl(exchanger).start();
    }
}

class Boy extends Thread{
    private Exchanger<String> exchanger;
    public Boy(Exchanger<String> exchanger){
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        System.out.println("男孩开始做好自己的定情信物：同心🔒");
        //交换结果:送出自己的定情信物，交换女孩的礼物
        try {
            String rs = exchanger.exchange("同心🔒");
            System.out.println("男孩收到礼物"+rs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Girl extends Thread{
    private Exchanger<String> exchanger;
    public Girl(Exchanger<String> exchanger){
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        System.out.println("男孩开始做好自己的定情信物：钥匙🔑");
        //交换结果
        try {
            String rs = exchanger.exchange("钥匙🔑");
            System.out.println("女孩收到礼物"+rs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}