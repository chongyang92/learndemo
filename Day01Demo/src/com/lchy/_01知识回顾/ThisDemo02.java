package com.lchy._01知识回顾;

/**
 * 目标：this关键字知识回顾。
 * this关键字的作用：
 *      this代表了当前对象的引用。
 *      this关键字可以用在实例方法和构造器中。
 *      this在方法中，谁调用这个方法，this就代表谁。
 *      this在构造器中，代表了构造器正在初始化的哪个对象的引用。
 */
public class ThisDemo02 {
    public static void main(String[] args) {
        /*在方法中*/
        Animal a1 = new Animal();
        a1.setName("金毛");
        System.out.println(a1.getName());
        /*在构造器中*/
        Animal a2 = new Animal("泰迪",3,'公');
        System.out.println(a2);

        /*在方法中*/
        Employee employee = new Employee();//无参构造器①
        employee.setName("张三");//②
        System.out.println(employee.getName());
        /*在构造器中*/
        Employee employee1 = new Employee("李四",28);//③
        System.out.println(employee1);
    }

}

//完整的javabean类
class Employee{
    private String name;//属性私有
    private int age;

    //无参构造器
    public Employee() {
    }

    //有参构造器
    public Employee(String name, int age) {//③
        this.name = name;//employee1.name = "李四"
        this.age = age;  //employee1.age = 28
    }

    //setter和getter方法
    public String getName() {
        return name;//employee.name
    }

    public void setName(String name) {
        //②哪个对象调用这个方法，this就代表谁
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

class Animal{
    private String name;
    private int age;
    private char sex;

    public Animal() {
    }

    public Animal(String name, int age, char sex) {
        this.name = name;  //a2.name = 泰迪
        this.age = age;    //a2.age = 3
        this.sex = sex;    //a2.sex = '公'
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;   //a1.name
    }

    /**
     * 设置
     * @param name
     * a1.setName("金毛");
     */
    public void setName(String name) {
        //谁调用这个方法，this就代表谁
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
     * @return sex
     */
    public char getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(char sex) {
        this.sex = sex;
    }

    public String toString() {
        return "Animal{name = " + name + ", age = " + age + ", sex = " + sex + "}";
    }
}
