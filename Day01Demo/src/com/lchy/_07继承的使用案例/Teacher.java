package com.lchy._07继承的使用案例;

public class Teacher extends People {
    //特有功能
    public void teach(){
        //System.out.println(name+"");//name是父类私有成员方法，不能直接使用
        System.out.println(getName()+"老师教课");
    }
}
