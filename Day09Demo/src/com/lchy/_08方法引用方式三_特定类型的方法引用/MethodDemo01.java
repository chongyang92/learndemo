package com.lchy._08方法引用方式三_特定类型的方法引用;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
      目标：方法引用有四种形式：

      1.静态方法的引用。
      2.实例方法的引用。
      3.特定类型方法的引用。
      4.构造器引用。

      3.特定类型方法的引用。
           特定类型：String ,任何类型。
           格式：特定类型::方法。
           注意：
              如果第一个参数列表中的形参中的第一个参数作为了后面的方法的调用者，
              并且其余参数作为后面方法的形参，那么就可以用特定类型方法引用了。
 
*/
public class MethodDemo01 {
    public static void main(String[] args) {
        String[] strs = new String[]{"James", "AA", "John",
                "Patricia","Dlei" , "Robert","Boom", "Cai" ,"black" ,
                "Michael", "Linda","cai","after","sCCC"};

        // public static <T> void sort(T[] a, Comparator<? super T> c)
        // 需求：按照元素的首字符(忽略大小写)升序排序！！！
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);// 按照元素的首字符(忽略大小写)比较。
            }
        });
        Arrays.sort(strs, (String s1, String s2) -> {
                return s1.compareToIgnoreCase(s2);// 按照元素的首字符(忽略大小写)比较。
        });

        Arrays.sort(strs, ( s1,  s2 ) ->  s1.compareToIgnoreCase(s2));

        // 特定类型的方法引用：
        Arrays.sort(strs, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(strs));

        List<Orange> oranges = new ArrayList<>();
        Orange o1 = new Orange("红橘子",654.0 ,"贼便宜~");
        Orange o2 = new Orange("黄橘子",454.0 ,"贼便宜~");
        Orange o3 = new Orange("黄橘子",454.0 ,"贼便宜~");
        Orange o4 = new Orange("青橘子",456.0 ,"贼便宜~");
        Collections.addAll(oranges,o1,o2,o3,o4);
        //这里的map方法，Function接口要求R apply(T t)，传一个参数，有一个返回值，现在，把参数变成调用对象，
        //当做特定类型的方法引用，就可以引用无参方法
        List<String> collect = oranges.stream().filter(s -> s.getWeight() < 456.0)
                .map(new Function<Orange, String>() {

                    @Override
                    public String apply(Orange orange) {
                        return orange.getName();
                    }
                }).collect(Collectors.toList());

        List<String> collect1 = oranges.stream().filter(s -> s.getWeight() < 456.0)
                .map(orange -> orange.getName()).collect(Collectors.toList());

        List<String> collect2 = oranges.stream().filter(s -> s.getWeight() < 456.0)
                .map(Orange::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
