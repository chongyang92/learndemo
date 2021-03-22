package com.lchy._07方法引用方式二_实例方法的引用;

@FunctionalInterface
interface Test {
    public String run(String string);
}

class Person {
    public String goWalking(String string) {
        return string.concat(" 引用方法");
    }
}

public class Blog {
    public static void main(String[] args) {
        //实质代码:      test t1 = (string) -> new Person().goWalking(string);
        //实质代码:     System.out.println(t1.run("对象"));
        Test t2 = new Person()::goWalking;
        System.out.println(t2.run("对象"));        //输出:对象 引用方法
    }
}
