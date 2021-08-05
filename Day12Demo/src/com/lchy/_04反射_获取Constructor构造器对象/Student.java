package com.lchy._04反射_获取Constructor构造器对象;

public class Student {
    private String name;
    private Integer age;

    private Student() {
        System.out.println("无参构造器被执行~~~~");
    }

    public Student(String name, int age) {
        System.out.println("有参构造器被执行~~~~");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
