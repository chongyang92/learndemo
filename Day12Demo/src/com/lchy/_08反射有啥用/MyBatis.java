package com.lchy._08反射有啥用;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class MyBatis {
    //提供一个方法：可以保存切对象数据的字段和具体值
    public static void save(Object obj){
        //try(PrintStream ps = new PrintStream()) {
        try(PrintStream ps = new PrintStream(new FileOutputStream("Day12Demo/src/data.txt",true))) {
            //解析对象的字段和每个字段的值存储起来！
            // obj = Student/Pig/Teacher
            // 1.先得到对象的Class文件对象
            Class<?> aClass = obj.getClass();
            //2. 定位它的全部成员变量
            Field[] declaredFields = aClass.getDeclaredFields();
            //3.遍历这些字段并取值
            for (Field declaredField : declaredFields) {
                //字段名称
                String name = declaredField.getName();
                declaredField.setAccessible(true);
                //字段的值
                String value = declaredField.get(obj) + "";
                ps.println(name+"="+value);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
