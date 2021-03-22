package com.lchy._04多态_引用类型强制类型转换;

/**
     目标：引用类型强制类型转换

     引用类型强制类型转换的语法：
     1.父类类型的变量或者对象必须强制类型转换成子类类型的变量，否则报错!

     强制类型转换的格式：
     类型 变量名称 = (类型)(对象或者变量)

     注意：有继承/实现关系的两个类型就可以进行强制类型转换，编译阶段一定不报错！
     但是运行阶段可能出现：类型转换异常 ClassCastException

     Java建议在进行强制类型转换之前先判断变量的真实类型，再强制类型转换!
     变量 instanceof 类型： 判断前面的变量是否是后面的类型或者其子类类型才会返回true,

 小结：
 有继承/实现关系的两个类型就可以进行强制类型转换，编译阶段一定不报错！
 但是运行阶段可能出现：类型转换异常 ClassCastException
 Java建议在进行强制类型转换之前先判断变量的真实类型，再强制类型转换!
 变量 instanceof 类型： 判断前面的变量是否是后面的类型或者其子类类型才会返回true,


 */
public class PolymorphicDemo {
    public static void main(String[] args) {
        //父类型 对象名称 = new 子类构造器;
        Animal dogAnimal = new Dog();//改为狗，就是组件化切换
        System.out.println(dogAnimal.name);//变量，编译和运行都看左边
        dogAnimal.run();

        //dogAnimal.lookdoor();//不能调用独有方法

        //1.把动物类型的变量 dog 转换成 真实的狗类型
        Dog dog =  (Dog)dogAnimal;
        dog.lookDoor();

        //2.多态下类型转换异常问题研究(重点)
        Animal catAnimal = new Cat();
        /*Dog dog1 = (Dog) catAnimal;
        dog1.lookDoor();//ClassCastException*/

        if(catAnimal instanceof Cat){
            Cat cat = (Cat)catAnimal;
            cat.catchMouse();
        }else if(catAnimal instanceof Dog){
            Dog dog2 = (Dog)catAnimal;
            dog2.lookDoor();
        }
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

    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}

class Animal{
    //变量：编译看左边，运行也看左边
    public String name = "动物名称";

    public void run(){
        System.out.println("动物跑");
    }
}
