package com.lchy._10内部类_匿名内部类_重点;

/**
    目标：匿名内部类的使用形式（关注语法）

    需求：很多角色要一起参加游泳比赛(老师、学生、运动员)
 */
public class Anonymity02 {
    public static void main(String[] args) {
        //对象回调:一个匿名内部类里有实现，把它的地址传给接口，接口会返回来调已实现的内部类
        Swimable zhangsan = new Swimable() {
            @Override
            public void Swimming() {
                System.out.println("张三游的贼溜");
            }
        };
        go(zhangsan);

        /*Swimable lisi = new Swimable() {
            @Override
            public void Swimming() {
                System.out.println("李四在游泳");
            }
        };
        go(lisi);*/
        go(new Swimable() {
            @Override
            public void Swimming() {
                System.out.println("李四在游泳");
            }
        });

    }

    //提供一个方法让全部角色进入比赛
    public static void go(Swimable swim){
        System.out.println("开始。。。");
        swim.Swimming();
        System.out.println("结束。。。");
    }
}

//参加比赛需要会游泳
interface Swimable{
    void Swimming();
}
