package com.lchy._10异常的强大之处;

import java.io.Serializable;
import java.util.Scanner;

/**
    目标：异常的作用
        1.可以处理代码问题，防止程序出现异常后的死亡
        2.提高了程序的健壮性和安全性。
 */
public class Demo {
    public static void main(String[] args) {
        //请输入一个合法的年龄
        Scanner scanner = new Scanner(System.in);
        //出现异常后仍然会退出
        /*
        while (true){
            System.out.println("请输入年龄");
            int age = scanner.nextInt();
            System.out.println("年纪是：" + age);
        }*/
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入年龄");
                int age = sc.nextInt();
                System.out.println("年纪是：" + age);
                break;
            }catch (Exception e){
                System.out.println("输入的年龄错误");
            }

        }
    }
}
