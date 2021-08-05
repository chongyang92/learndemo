package com.lchy._06反射_获取Method方法并执行;

import org.junit.Test;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

/**
    目标：反射——获取Method方法对象

    反射获取类的Method方法对象
        1、Method getMethod(String name,Class... args);
            根据方法名和参数类型获得对应方法对象，只能获得public的
        2、Method getDeclaredMethod(String name,Class... args);
            根据方法名和参数类型获得对应的方法对象，包括private的
        3、Method[] getMethods();
            获得类中的所有成员方法对象，返回数组，只能获得public修饰的且包含父类的
        4、Method[] getDeclaredMethods();
            获得类中所有成员方法对象，返回数组，只获得本类申明的方法。
    Method的方法
        Object invoke(Object obj, Object... args)
            参数一： 触发的是哪个对象的方法执行。
            参数二： args: 调用方法时传递的实际参数
 */
public class MethodDemo01 {
    /**
     *1.获得类中所有的成员方法对象
     */
    @Test
    public void getDeclaredMethods(){
        //a.先获取class类对象
        Class<Dog> dogClass = Dog.class;
        //b.获取全部申明的方法
        Method[] declaredMethods = dogClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //c.遍历这些方法
            //方法名
            System.out.println(declaredMethod.getName());
            //返回类型
            AnnotatedType annotatedReturnType = declaredMethod.getAnnotatedReturnType();
            System.out.println(annotatedReturnType.getType());
            //参数个数
            System.out.println(declaredMethod.getParameterCount());
            System.out.println();
        }
    }

    /**
     * 2.获取某个方法对象
     */
    @Test
    public void getDeclaredMethod() throws Exception{
        //a.先获取class类对象
        Class<Dog> dogClass = Dog.class;
        Method run = dogClass.getDeclaredMethod("run");
        //c.触发方法执行
        Dog jinMao = new Dog();
        Object invokeRun = run.invoke(jinMao);//触发jinMao对象的run()方法执行
        System.out.println(invokeRun);

        /**
         * 参数一： 方法名称
         * 参数二：方法的参数个数和类型（可变参数！）
         */
        Method eat = dogClass.getDeclaredMethod("eat", String.class);
        eat.setAccessible(true);
        Object invokeEat = eat.invoke(jinMao, "骨头");//触发jinMao对象的eat()方法
        System.out.println(invokeEat);

    }
}
