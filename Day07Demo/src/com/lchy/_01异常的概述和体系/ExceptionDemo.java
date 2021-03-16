package com.lchy._01异常的概述和体系;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
    目标：异常的概念和体系

    什么是异常？
        异常是程序在“编译”或者“执行”(越界)的过程中可能出现的问题。
             常见的编译时异常
             1.FileNotFoundException 编译结果文件夹里面找不到
             2.ClassNotFoundException
             3.SQLException
             4.NoSuchFieldException
             5.NoSuchMethodException
             6.ParseException

             常见的运行时异常
             1.NullPointerException
             2.ArithmeticException
             3.ClassCastException
             4.ArrayIndexOutOfBoundsException
             5.StringIndexOutOfBoundsException
        异常是应该尽量提前避免的。
        异常可能也是无法做到绝对避免的，异常可能有太多情况了，开发中只能提前干预！
        异常一旦出现了，如果没有提前处理，程序就会退出JVM虚拟机而终止，开发中异常是需要提前处理的。

        研究异常并且避免异常，然后提前处理异常，体现的是程序的安全，健壮性！

        Java会为常见的代码异常都设计一个类来代表。

    异常的体系：
        Java中异常继承的根类是：Throwable

            Throwable(根类，不是异常类)
        /             \
      Error          Exception(异常，需要研究和处理)
                    /       \
                 编译时异常    RuntimeException(运行时异常)

        Error:错误的意思，严重错误Error，无法通过处理的错误，一旦出现，程序员无能为力
            只能重启系统，优化项目
            比如内存崩溃，JVM本身的崩溃，这个程序员无需理会

        Exception:才是异常类，它才是开发中代码在编译或者执行的过程中可能出现的错误
            它是需要提前处理的，以便程序更加健壮！

        Exception异常的分类：
            1.编译时异常：继承自Exception的异常或者其子类，编译阶段就会报错，
                    必须程序员处理的，否则代码编译就不能通过！

            2.运行时异常：继承自RuntimeException的异常或者其子类，编译阶段是不会出错的，
                    它是在运行时阶段可能出现，运行异常可以处理也可以不处理，编译阶段不会出错的
                    但是运行阶段可能出现，建议提前处理！

    小结：
        异常是程序在编译或者运行的过程中可能出现的错误！
        异常分为2类：编译时异常，运行时异常。
            --编译时异常：继承了Exception，编译阶段就报错，必须处理，否则代码不通过
            --运行时异常：继承了RuntimeException编译阶段不会报错，运行时才可能出现
        异常一旦真的出现，程序会终止，所以要研究异常，避免异常，处理异常，程序更健壮！

        举例：上传头像，传了一半，网断了，会抛出异常，导致程序终止，所以要避免，避免不了就处理，
        给用户一个反馈，保持程序运行。


 */
public class ExceptionDemo {
    public static void main(String[] args) throws ParseException {//这里会有

        //编译时异常，因为paras方法会抛出ParseException异常，parse被调用处，可以在方法上加throws，继续上抛，或者try catch,处理掉
        String date = "2019-11-04 09:30:30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date newDate = sdf.parse(date);

        System.out.println("程序开始。。。");

        int[] arr = {1,3,5};
        System.out.println(arr[3]);//ArrayIndexOutOfBoundsException
        System.out.println("程序结束。。。");
    }
}
