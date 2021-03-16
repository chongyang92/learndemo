package com.lchy._05异常_编译时异常的处理机制;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
    目标：编译时异常处理方式三

    方式三： 在出现异常的地方把异常一层一层的抛出给最外层调用者
            最外层调用者集中捕获处理！(规范做法)

    小结：
        编译时异常的处理方式三：底层出现的异常抛出给最外层调用者几种捕获处理。
        这种方案最外层调用者可以知道底层执行的情况，同时程序在出现异常后也不会立即死亡，
        这理论上是最好的方法。

        虽然异常有三种处理方式，但是开发中只要能解决你的问题，每种方式都有可能用到。
 */
public class ExceptionDemo03 {
    public static void main(String[] args) throws Exception {
        System.out.println("程序开始。。。");
        try{
            parseDate("2013-03-23 10:10:23");
            System.out.println("程序执行成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("程序执行失败");

        }

        System.out.println("程序结束。。。");
    }

    private static void parseDate(String time) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        System.out.println(sdf.parse(time));

        InputStream is = new FileInputStream("D://img.jpg");
    }
}
