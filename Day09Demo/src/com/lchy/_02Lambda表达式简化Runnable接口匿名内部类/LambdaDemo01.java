package com.lchy._02Lambda表达式简化Runnable接口匿名内部类;

/**
    目标：Lambda表达式简化Runnable接口的匿名内部类写法

    @FunctionalInterface函数式接口注解
        一旦某个接口加上了这个注解，这个接口只能有且仅有一个抽象方法
        这个接口就可以被Lambda表达式简化。

    Lambda表达式只能简化函数式接口的匿名内部类写法：
        a.首先必须是接口
        b.接口中只能由一个抽象方法

    小结：
        lambda表达式只能简化接口中只有一个抽象方法的匿名内部类写法
        接口中只有一个个抽象方法的接口称为函数式接口
        Lambda只能简化函数式接口的匿名内部类写法
 */
public class LambdaDemo01 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("haha");
            }
        });

        Thread t1 = new Thread(() -> System.out.println("haha"));
    }
}
