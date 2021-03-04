package com.lchy._02抽象类的使用;

/**
    目标：抽象类的使用；

    抽象类的作用：为了被子类继承，

    小结：
        一个类继承了抽象类，必须重写完抽象类的全部抽象方法，否则这个类也必须定义成抽象类；
 */
public class AbstractDemo {
    public static void main(String[] args) {
        Teacher boZai = new Teacher();
        boZai.work();

        Manager boNiu = new Manager();
        boNiu.work();
    }

}

class Manager extends Employee{
    @Override
    public void work() {
        System.out.println("班主任管理学生");
    }
}

class Teacher extends Employee{
    @Override
    public void work() {
        System.out.println("讲师讲课");
    }
}

//需求，一家公司开发员工管理系统，（讲师、班主任）
abstract class Employee{
    //子类都要完成工作这个功能，但是每个子类工作内容不一样，那么就定义抽象方法。
    public abstract void work();
}
