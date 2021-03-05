package com.lchy._12Object类的详细使用;

import java.util.Objects;

public class Teacher {
    private String name;
    private int age;
    private double salary;

    public Teacher(){

    }
    public Teacher(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String toString(){
        return "Teacher{"
                +"name="+name
                +" ,age="+age
                +" ,salary="+salary
            +"}";
    }

    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher)o;

        return this.age == teacher.getAge() && this.salary == teacher.getSalary()
                && Objects.equals(name,teacher.name);//Objects可以判断对象是否为null
        /*public static boolean equals(Object a, Object b) {
            return a == b || a != null && a.equals(b);
        }*/
    }

}
