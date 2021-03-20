package com.lchy._04set系列集合的使用;

import java.util.Objects;

//最好把泛型加上
public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;
    private int age;

    public Employee() {
    }

    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}' + '\n';
    }

    //重写了比较方法
    //e1.compareTo(o)
    //比较者：this
    //被比较者：o
    //需求：按照年龄比较
    @Override
    public int compareTo(Employee o) {
        //规则：Java规则，如果程序员认为比较者大于被比较者，返回正数！
        //规则：Java规则，如果程序员认为比较者小于被比较者，返回负数！
        //规则：Java规则，如果程序员认为比较者等于被比较者，返回零！

        //return 0;//如果直接返回0那么因为不重复，只有1个元素
        //return this.age - o.age;//升序，但是这样，同龄的都不允许存在了
        int num = this.age - o.age;
        int num1 = num == 0 ? Double.compare(this.salary ,o.salary ) : num;  //这里的compare返回一个int
        int num2 = num1 == 0 ? this.name.compareTo(o.name) : num1;      //在类的内部，可以直接访问私有变量

        return num;


    }

}
