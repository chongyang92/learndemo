package com.lchy._04Lambda表达式的省略写法;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 Lambda表达式的省略写法（进一步在Lambda表达式的基础上继续简化）
    （1）如果Lambda表达式的方法体代码只有一行代码。可以省略大括号不写,同时要省略分号！
    （2）如果Lambda表达式的方法体代码只有一行代码。可以省略大括号不写。
        此时，如果这行代码是return语句，必须省略return不写，同时也必须省略";"不写
    （3）参数类型可以省略不写。
    （4）如果只有一个参数，参数类型可以省略，同时()也可以省略。

 */
public class LambdaDemo01 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("胡伟光");
        names.add("甘挺");
        names.add("洪磊");

        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //省略接口名，将方法参数列表提上来
        names.forEach((String s) -> {
                System.out.println(s);
        });
        //省略参数类型
        names.forEach((s) -> {
            System.out.println(s);
        });
        //一个参数省略方法参数小括号，多个不能省
        names.forEach(s -> {
            System.out.println(s);
        });
        //一条执行语句，省略{}，多条语句不能省
        names.forEach(s -> System.out.println(s) );
        //最终可简化为方法引用，即参数s和的个数和类型和println()相同，即可使用方法引用
        names.forEach(System.out::println);//此处方法引用分类中的，对象::成员方法引用

    }
}


