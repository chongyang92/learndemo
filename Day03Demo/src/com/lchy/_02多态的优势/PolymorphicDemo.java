package com.lchy._02多态的优势;

/**
    目标：多态的优势

    优势：
        1.在多态形式下，右边对象可以实现组件化切换(new Cat()换为new Dog())，业务功能也随之改变，
            便于扩展和维护。可以实现类与类之间的解耦。
        2.实际开发过程中，父类类型作为方法形式参数，传递子类对象给方法，
            可以传入一切子类对象进行方法调用，更能体现出多态的扩展性和便利性。
    劣势：
        1.多态形式下，不能直接调用子类独有功能，编译看左边


 */
public class PolymorphicDemo {
    public static void main(String[] args) {
        //父类型 对象名称 = new 子类构造器;
        Animal catAnimal = new Cat();//改为狗，就是组件化切换
        catAnimal.run();


        Dog dog = new Dog();
        goDog(dog);//限制了只能传dog

        Animal dogAnimal = new Dog();
        go(dogAnimal);

        go(catAnimal);

        //dogAnimal.lookdoor();//独有功能

    }

    //开发一个游戏 所有动物都可以进来比赛
    public static void goDog(Dog dog){
        System.out.println("开始");
        dog.run();
        System.out.println("结束");
    }

    //开发一个游戏 所有动物都可以进来比赛
    public static void go(Animal animal){
        System.out.println("开始");
        animal.run();
        System.out.println("结束");
    }
}



class Dog extends Animal {
    public String name = "狗名称";
    @Override
    public void run() {
        System.out.println("狗在跑");
    }

    //独有功能
    public void lookDoor(){
        System.out.println("狗看门");
    }
}

class Cat extends Animal {
    public String name = "猫名称";
    @Override
    public void run() {
        System.out.println("猫在跑");
    }
}

class Animal{
    //变量：编译看左边，运行也看左边
    public String name = "动物名称";

    public void run(){
        System.out.println("动物跑");
    }
}
