package com.lchy._08接口的基本实现;

/**
    目标：接口的基本实现。

    子类       继承   父类
    实现类     实现   接口

    类与类是继承关系。
    类与接口是实现关系，接口是被类实现的。
    实现接口的类成为，实现类。

    类实现接口的格式：
            修饰符  class 实现类名称  implements 接口1，接口2，接口3.。。{

            }
            implements：类实现接口的关键字。
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        PingSport ping = new PingSport();
        ping.run();
        ping.competition();
    }
}

class PingSport implements SportMan {
    @Override
    public void run() {
        System.out.println("运动员要跑步");
    }

    @Override
    public void competition() {
        System.out.println("运动员要参加比赛");
    }
}

interface SportMan{
    void run();
    void competition();
}