package com.lchy._16引用类型作为方法参数和返回值;

/**
 * 目标：引用类型作为方法参数和返回值
 *
 * 引用类型作为Java的数据类型，自然可以作为方法的参数类型和返回值类型。
 * 除了基础数据类型，都是引用数据类型
 */
public class TestDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        run(dog);

        Dog dog1 = createDog();
    }
    //提供静态方法让狗进入比赛
    public static void run(Dog d){
        d.run();
    }

    public static Dog createDog(){
        Dog dog =  new Dog();
        //这里可以堆dog进行初始化
        return dog;
    }
}

class Dog{
    public void run() {
        System.out.println("狗跑的贼溜");
    }
}
