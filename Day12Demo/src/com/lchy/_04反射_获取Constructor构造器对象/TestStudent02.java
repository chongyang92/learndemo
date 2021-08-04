package com.lchy._04反射_获取Constructor构造器对象;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
    目标：反射_获取Constructor构造器然后通过这个构造器初始化对象。

    反射获取Class中的构造器对象Constructor作用：
        也是初始化并得到类的一个对象返回。

    Constructor的API：
        1.T newInstance(Object... initargs)
            创建对象，注入构造器需要的数据。
        2.void setAccessible(true)
            修改访问权限，ture代表暴力攻破权限，false表示保留不可访问权限(暴力反射)
    小结：
        可以通过定位类的构造器对象。
        如果构造器对象没有访问权限可以通过：void setAccessible(true)打开权限
        构造器可以通过T newInstance(Object... initargs)调用自己，传入参数！
 */
public class TestStudent02 {
    //调用无参数构造器得到一个类的对象返回
    @Test
    public void createObj01() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //a.反射第一步是先得到Class类对象
        Class<Student> studentClass = Student.class;
        Constructor<Student> constructor = studentClass.getDeclaredConstructor();
        //c.暴力打开私有构造器的访问权限。
        constructor.setAccessible(true);
        Student student = constructor.newInstance();
        System.out.println(student);
    }
    //调用有参数构造器得到一个类的对象返回
    @Test
    public void createObj02() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //a.反射第一步是先得到Class类对象
        Class<Student> studentClass = Student.class;
        Constructor<Student> constructor = studentClass.getDeclaredConstructor(String.class,int.class);
        //c.暴力打开私有构造器的访问权限。
        constructor.setAccessible(true);
        Student student = constructor.newInstance("孙悟空",100);
        System.out.println(student);
    }
}
