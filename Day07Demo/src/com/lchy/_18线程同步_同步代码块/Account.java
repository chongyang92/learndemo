package com.lchy._18线程同步_同步代码块;
//账户类
public class Account {
    private String cardID;
    private double money;

    public Account() {
    }

    public Account(String cardID, double money) {
        this.cardID = cardID;
        this.money = money;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    //小明小红线程
    public void drawMoney(double money){//实例方法

        //开始判断取钱逻辑
        //1.先知道是谁来取钱
        String name = Thread.currentThread().getName();
        //2.判断余额是否足够
        //锁代码的范围越小越好
        synchronized(this) {//drawMoney为静态方法时，synchronized(Account.class)
            if (this.money >= money) {
                System.out.println(name + "来取钱，余额足够，吐出" + money);
                //3.更新余额
                this.money -= money;
                System.out.println(name + "来取钱，余额剩余" + this.money);
            } else {
                System.out.println(name + "来取钱，余额不足");
            }
        }
    }
}
