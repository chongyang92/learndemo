package com.lchy.总结;

class Animal {
    public static String name = "动物名称";
    public void run(){
        System.out.println("Animal is run!");
    }

    public static void go(){
        System.out.println("Animal is go!");
    }
}

class Horse extends Animal{
    public static String name = "驴名称";
    @Override
    public void run() {
        System.out.println("Horse is run!");
    }

    public static void go(){
        System.out.println("Horse is go!");
    }
}

public class Test {

    static void method(Animal a){
        System.out.println ("Animal is called.");
    }

    static void method(Horse h){
        System.out.println ("Horse is called.");
    }

    public static void main (String[] args) {

        Animal a = new Animal();
        Horse h = new Horse();
        Animal ah = new Horse();
        System.out.println("-------重载-------");//根据类型匹配方法
        method(a);
        method(h);
        method(ah);
        System.out.println("-------重写成员方法-------");//就近原则,先子类范围找，后父类范围找
        a.run();
        h.run();
        ah.run();
        System.out.println("-------\"重写\"静态方法-------");//建议类名调用，对象调用没有重写，什么类型对象就调什么类型方法，和子类无关
        Animal.go();
        Horse.go();
        ah.go();
        System.out.println("--------变量不重写---------");//编译和运行都看左边
        System.out.println(a.name);
        System.out.println(h.name);
        System.out.println(ah.name);
    }
}
