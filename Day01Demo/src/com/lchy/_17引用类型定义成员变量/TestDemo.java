package com.lchy._17引用类型定义成员变量;

/**
 * 目标：引用类型作为成员变量的类型（复合类型）
 */
public class TestDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("zhengcongqing");
        student.setAge(20);

        Address address = new Address("100","guangzhoutianhe",80,90);
        student.setAddress(address);

        Address address1 = student.getAddress();
        System.out.println(address1.getCode()+address1.getName());
    }
}
