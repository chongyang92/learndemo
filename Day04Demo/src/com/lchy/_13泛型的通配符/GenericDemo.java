package com.lchy._13泛型的通配符;

import java.util.ArrayList;

/**
    目标：泛型通配符

    需求：开发一个极品飞车的游戏，所有汽车都能一起参与比赛。

    注意：
        虽然BMW和BENZ都继承了Car
        但是ArrayList<BMW>和ArrayList<BENZ>与ArrayList<Car>没有关系的，泛型变量没有继承关系！
        由此引出？通配符
    通配符：？问号
        ？可以用在使用泛型的时候代表一切类型。
        E , T ,K , V是在定义泛型的时候使用
        ？是在使用的时候，代表一切类型例public static void run(ArrayList<?> cars)
        ?问号是能接收所有类型了，但是没有限制了，由此引出泛型上下限

    泛型的上下限：
        ？ extends Car :那么?必须是Car或者Car的子类 (泛型的上限)
        ? super    Car:那么?必须是Car或者其父类  (泛型的下限，不是很常见)

    小结：
        通配符：？可以用在使用泛型的时候代表一切类型。
        ? extends Car :那么?必须是Car或者其子类(泛型的上限)
 */
public class GenericDemo {
    public static void main(String[] args) {
        ArrayList<BMW> bmws = new ArrayList<>();
        bmws.add(new BMW());
        bmws.add(new BMW());
        bmws.add(new BMW());
        run(bmws);

        ArrayList<BENZ> benzs = new ArrayList<>();
        benzs.add(new BENZ());
        benzs.add(new BENZ());
        benzs.add(new BENZ());
        run(benzs);

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());
        //run(dogs);//run方法使用ArrayList<?> cars，也可以接收Dog了，这不合理
    }

    /*定义一个方法，可以让很多汽车一起进入参加比赛*/
    /*public static void run(ArrayList<BMW> cars){//只能操作BMW或BENZ

    }*/

    /*public static void run(ArrayList<Car> cars){//BMW或BENZ都不可以接收，泛型变量没有继承关系

    }*/

    /*public static void run(ArrayList<?> cars){//只用?,表示可以接收任意类型，dog也可以传进来

    }*/

    public static void run(ArrayList<? extends Car> cars){//?代表调用run方法时传入的类型，extends表示必须继承后面的Car类

    }
}


class Car{

}

class BMW extends Car{

}

class BENZ extends Car{

}

class Dog{

}