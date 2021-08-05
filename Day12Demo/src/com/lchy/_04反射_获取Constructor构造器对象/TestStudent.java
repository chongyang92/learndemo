package com.lchy._04反射_获取Constructor构造器对象;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
    目标：反射_获取Constructor构造器对象。

    反射的第一步是先得到Class类对象。（class文件）

    反射中Class类型获取构造器提供了很多API:
        1.Constructor getConstructor(Class... parameterTypes)
            根据参数匹配获取某个构造器，只能拿public修饰的构造器，几乎不用！
        2.Constructor getDeclaredConstructor(Class... parameterTypes)
            根据参数匹配获取某个构造器，只要申明就可以定位，不关心权限修饰符，建议使用！
        3.Constructor[] getContructors()
            获取所有的构造器，只能拿public修饰的构造器。几乎不用，太弱了！
        4.Constructor[] getDeclaredConstructors()
            获取所有申明的构造器，只要你写我就能拿到，无所谓权限，建议使用！

    小结：
        获取类的全部构造器对象：Constructor[] getDeclaredConstructors[]
            --获取所有申明的构造器，只要你写我就能拿到，无所谓权限。建议使用！
        获取类的某个构造器对象：Constructor getDeclaredConsturctor(Class... parameterType)
    反射与单例：单例是指一个类只有一个对象。
            单例特点是私有构造器（private 类名(){}不能在外部创建对象），私有静态常量实例（private static final 类名）,公共的静态获取实例方法(public 类名 getInstance())
            如果使用反射的getDeclaredConstructor或者getDeclaredConstructors(),就会直接获取私有的构造器(直接创建对象)和私有静态常量
 */
public class TestStudent {
    //获取public权限的构造器
    @Test
    public void getConstructors(){
        Class<Student> studentClass = Student.class;
        Constructor<?>[] constructors = studentClass.getConstructors();
        for(Constructor constructor : constructors){
            String name = constructor.getName();
            int parameterCount = constructor.getParameterCount();
            System.out.println(name+" 参数："+parameterCount);
        }
    }

    //获取所有权限的构造器
    @Test
    public void getDeclaredConstructors(){
        Class<Student> studentClass = Student.class;
        Constructor<?>[] constructors = studentClass.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            String name = constructor.getName();
            int parameterCount = constructor.getParameterCount();
            System.out.println(name+" 参数："+parameterCount);
        }
    }

    //获取某一个public构造器
    @Test
    public void getConstructor() throws NoSuchMethodException {
        Class<Student> studentClass = Student.class;
        Constructor<Student> constructor = studentClass.getConstructor();//无参构造器是private，用这个方法拿不到，报错
        System.out.println(constructor.getName());
    }

    //获取某一个构造器,所有权限
    @Test
    public void getDeclaredConstructor() throws NoSuchMethodException {
        Class<Student> studentClass = Student.class;
        Constructor<Student> constructor = studentClass.getDeclaredConstructor();//获取private无参构造器
        System.out.println(constructor.getName()+" 参数："+constructor.getParameterCount());
    }

    //获取某一个构造器,所有权限
    @Test
    public void getDeclaredConstructor1() throws NoSuchMethodException {
        Class<Student> studentClass = Student.class;
        Constructor<Student> constructor = studentClass.getDeclaredConstructor(String.class, int.class);
        //Constructor<Student> constructor1 = studentClass.getDeclaredConstructor(String.class, Integer.class);//这里的参数，基本类型和对象不能通用
        System.out.println(constructor.getName()+" 参数："+constructor.getParameterCount());
    }
}
