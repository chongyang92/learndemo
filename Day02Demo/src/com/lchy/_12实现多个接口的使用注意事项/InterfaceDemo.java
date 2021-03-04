package com.lchy._12实现多个接口的使用注意事项;

/**
    1、如果实现了多个接口，多个接口中存在同名的静态方法并不会冲突，
        原因是只能通过各自接口名访问各自静态方法。
    2、当一个类实现接口时，类中方法和接口中默认(default)方法同名
        且同参数，构成了重写；
        参数不同，构成重载；
    3、当一个类，既继承一个父类，又实现若干个接口时(重点)
        父类中的成员方法与接口中的默认方法重名，子类就近选择执行父类成员方法，构成了重写。
    4.当一个类实现多个接口，多个接口中存在同名的默认方法。
    实现类必须重写这个方法
    5.接口中没有构造器，不能创建对象(重点)
    接口是更彻底的抽象，连构造器都没有，自然不能创建对象！

    接口：缺点，
    抽象类：缺点，只能单继承
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        C c = new C();
        //c.test();//
        c.run();

        //3.
        D d = new D();
        d.run();
    }
}

class D extends C implements A,B{

}

class C implements A,B{
    //2.当一个类实现接口时，类中方法和接口中默认(default)方法同名
    //重写接口中默认的run方法
    public void run() {
        System.out.println("C run");
    }
    public void run(String s) {
        System.out.println();
    }
}

interface A{
    //1.实现了多个接口，多个接口中存在同名的静态方法并不会冲突
    static void test(){
        System.out.println("A");
    }
    default void run(){
        System.out.println("A run");
    }
}

interface B{
    static void test(){
        System.out.println("B");
    }
}

/**
    4.当一个类实现多个接口，多个接口中存在同名的默认方法。
    实现类必须重写这个方法
 */
class C1 implements A1,B1{

    @Override
    public void test() {
        System.out.println("C1");
    }
}

interface A1{
    default void test(){
        System.out.println("A2");
    }
}

interface B1{
    default void test(){
        System.out.println("B1");
    }
}