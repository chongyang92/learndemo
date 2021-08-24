package com.lchy._15注解模拟Junit框架;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
    目标：自定义注解模拟写一个Junit框架的基本使用。

    需求：定义若干个方法，只要加了MyTest注解
        就可以被自动触发执行。

    分析：
        （1）定义一个自定义注解MyTest.
            -- 只能注解方法
            -- 存活范围一直都在
        （2）定义若干个方法，只要有@MyTest注解的方法就能被触发执行！
            没有这个注解的方法不能执行！
    小结：
        注解和反射可以配合解决一些框架思想
        注解可以实现标记的成分做特殊处理！
 */
public class TestDemo {
    @MyTest
    public void test01(){
        System.out.println("===test01===");
    }
    @Test
    public void test02(){
        System.out.println("===test02===");
    }
    public void test03(){
        System.out.println("===test03===");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //模拟测试类的启动按钮，实现有注解标记的方法就要触发执行。
        TestDemo testDemo = new TestDemo();
        //1.得到类对象
        Class<TestDemo> testDemoClass = TestDemo.class;
        Method[] declaredMethods = testDemoClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.isAnnotationPresent(MyTest.class)){
                //触发此方法执行。
                declaredMethod.invoke(testDemo);
            }
        }
    }
}

@Target(ElementType.METHOD) //只能注解方法
@Retention(RetentionPolicy.RUNTIME) //一直活着
@interface MyTest{

}