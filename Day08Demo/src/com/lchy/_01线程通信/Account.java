package com.lchy._01线程通信;

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
    //小明、小红
    public synchronized void drawMoney(double money) {
        try{
            //谁来取钱
            String name = Thread.currentThread().getName();
            //2.判断余额释放足够
            if(this.money >= money){
                //2.开始吐钱
                this.money -= money;
                System.out.println(name + "来取钱，取出："+money + "剩余："+this.money);
                //3.取钱后没钱了，唤醒别人等待自己
                this.notifyAll();
                this.wait();
            }else {
                this.notifyAll();
                this.wait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //亲爹、岳父、干爹
    public synchronized void saveMoney(double money) {
        try{
            //谁来取钱
            String name = Thread.currentThread().getName();
            //1.判断余额释放足够
            if(this.money > 0){
                //2.有钱了，唤醒别人等待自己
                this.notifyAll();
                this.wait();
            }else {
                //3.开始吐钱
                this.money += money;
                System.out.println(name + "来存钱："+money );
                this.notifyAll();
                this.wait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
