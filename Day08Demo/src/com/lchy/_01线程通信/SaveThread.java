package com.lchy._01线程通信;
//线程类：创建存钱线程
public class SaveThread extends Thread {
    //定义一个成员变量接收账户对象
    private Account account;

    public SaveThread(Account account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //小明、小红
            account.saveMoney(10000);
        }
    }
}
