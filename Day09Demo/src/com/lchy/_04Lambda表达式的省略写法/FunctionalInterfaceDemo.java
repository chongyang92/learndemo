package com.lchy._04Lambda表达式的省略写法;

/**
    目标：lambda表达式，简化只有一个抽象方法的接口，可以有default static private方法。

    可以有
 */
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        //接口不能有参数，因为没有构造器
        new Handle(new MyInterface() {
            @Override
            public void test(String s) {
                System.out.println("test");
            }
        }).test(null);
        //当new 和接口名都省略的时候，()就变成了方法的参数列表,要加->
        //方法声明都可以省略了，即(String s) -> 代替了public void test(String s)
        new Handle((String s) -> {//知道Handle接收MyInterface接口类型,重载自动匹配
                System.out.println("test");
        }).test(null);

    }
}
