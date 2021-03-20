package com.lchy._11自定义泛型方法;

/**
    目标：自定义泛型方法

    什么是泛型方法？
        定义了泛型的方法就是泛型方法。
    泛型方法的定义格式：
        修饰符 <泛型变量> 返回值类型 方法名称(形参列表){

        }
        注意：方法定义了是什么泛型变量，后面就只能用什么泛型变量。
        泛型类的核心思想：是把出现泛型变量的地方全部替换为传入真实的数据类型。

    需求：给你任何一个类型的数组，都能返回它的内容。
 */
public class GenericDemo {
    public static void main(String[] args) {
        Integer[] nums = {10, 20, 30, 40, 50};

        System.out.println(arrToString(nums));

        String[] names = {"贾乃亮","王宝强","陈羽凡"};

        System.out.println(arrToString(names));
    }
    //只能接Integer类型数组
    /*public static String arrToString(Integer[] nums){

    }*/
    //用Object可以接收所有数据类型
    /*public static String arrToString(Object[] nums){

    }*/
    //泛型代表一切类型， <>
    //public static <泛型变量> String arrToString(Object[] nums)
    public static <T> String arrToString(T[] nums){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if(nums != null && nums.length > 0){
            for (int i = 0; i < nums.length; i++) {
                T ele = nums[i];
                stringBuilder.append(i == nums.length -1  ? ele : ele + ",");
            }
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

//抽象类中也可以定义抽象的泛型方法
abstract class A{
    public abstract <T,E> String myToString(T t);
}

class B{
    public <T> String myToString(T t){
        return "";
    }
}

class C extends A{

    //@Override
    public <T,E> String myToString(T t) {
        return null;
    }
}

class D extends B{

}