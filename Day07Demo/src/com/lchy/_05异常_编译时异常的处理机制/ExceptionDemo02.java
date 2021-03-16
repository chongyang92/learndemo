package com.lchy._05异常_编译时异常的处理机制;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
    目标：编译时异常处理方式二

    方式二：在出现异常的地方自己处理，谁出现谁处理。

    自己捕捉异常和处理异常的格式：捕获处理
        try{
            //监视可能出现异常的代码！
        } catch(异常类型1 变量){
            //处理异常
        } catch(异常类型2 变量){
            //处理异常
        }...

    监视捕获处理异常企业级写法：
        try{
            //可能出现异常的代码！
        } catch(Exception e){
            e.printStackTrace(); //直接打印异常栈信息
        }

    小结：
        第二种方式，可以处理异常，并且出现异常后代码也不会死亡
        这种 方案还是可以的
        但是从理论上来说，这种方式不是最好的，上层调用者不能直接知道底层调用情况，不知道是否成功
 */
public class ExceptionDemo02 {
    public static void main(String[] args)  {
        System.out.println("程序开始。。。");
        parseDate("2013-03-23 10:10:23");
        System.out.println("程序结束。。。");
    }

    //太多catch了
    /*private static void parseDate(String time)  {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            sdf.parse(time);
            //出现了运行时异常，自动创建异常对象:AtithmeticException
            System.out.println("结果是：");

            InputStream is = new FileInputStream("D://img.jpg");
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("解析有问题");
        }
    }*/

    //JDK1.7之后
   /* private static void parseDate(String time)  {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            sdf.parse(time);
            //出现了运行时异常，自动创建异常对象:AtithmeticException
            System.out.println("结果是：");

            InputStream is = new FileInputStream("D://img.jpg");
        }catch (FileNotFoundException | ParseException e){//JDK1.7之后
            e.printStackTrace();//打印异常栈信息
            System.out.println("文件不存在");
        }
    }*/

   //企业级写法
    private static void parseDate(String time)  {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            sdf.parse(time);
            //出现了运行时异常，自动创建异常对象:AtithmeticException
            System.out.println("结果是：");

            InputStream is = new FileInputStream("D://img.jpg");
        }catch (Exception e){
            e.printStackTrace();//打印异常栈信息
        }
    }
}
