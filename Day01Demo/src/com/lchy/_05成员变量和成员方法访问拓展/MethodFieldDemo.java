package com.lchy._05成员变量和成员方法访问拓展;

/**
 * 拓展：成员变量和成员方法访问拓展(面试常考)
 * 方法：实例方法，静态方法
 * 成员变量：实例成员变量，静态成员变量。
 *
 * 8种访问形式的问答：
 *      a.实例方法是否可以直接访问实例成员变量？ 可以，都属于对象
 *      b.实例方法是否可以直接访问静态成员变量？ 可以，静态成变量可以被共享访问。
 *      c.实例方法是否可以直接访问实例方法？     可以
 *      d.实例方法是否可以直接访问静态方法？     可以
 *      -------------------------------------------------
 *      a.静态方法是否可以直接访问实例变量？ 不可以 静态方法不用创建对象，而实例变量必须是先创建对象
 *      b.静态方法是否可以直接访问静态变量？  可以
 *      c.静态方法是否可以直接访问实例方法?   不可以
 *      d.静态方法是否可以直接访问静态方法？   可以
 */
public class MethodFieldDemo {
    //静态成员变量
    public static String schoolName = "大学";
    //实例成员变量
    private String name;

    //静态方法
    public static void test(){
        //run();//不可以
    }

    //实例方法
    public void run(){

    }

    //实例方法
    public void eat(){
        run();
        test();
        System.out.println(schoolName);
        System.out.println(name);
    }
}
