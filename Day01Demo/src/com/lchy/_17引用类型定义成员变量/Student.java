package com.lchy._17引用类型定义成员变量;

/**
 *
 */
public class Student {
    private String name;
    private int age;
    //地址信息：复合类型
    //引用类型作为成员变量的类型
    private Address address;

    public Student() {
    }

    public Student(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + ", address = " + address + "}";
    }
}
