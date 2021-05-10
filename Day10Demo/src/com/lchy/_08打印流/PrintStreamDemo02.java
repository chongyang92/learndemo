package com.lchy._08打印流;

import java.io.IOException;
import java.io.PrintStream;

/**
    目标：打印流改变输出的流向，重定向。
 */
public class PrintStreamDemo02 {
    public static void main(String[] args) {

        try(
                PrintStream printStream = new PrintStream("Day10Demo\\src\\log.txt");){
            System.setOut(printStream);
            System.out.println("hello java1");
            System.out.println("hello java2");
            System.out.println("hello java3");
            System.out.println("hello java4");
            System.out.println("hello java5");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
