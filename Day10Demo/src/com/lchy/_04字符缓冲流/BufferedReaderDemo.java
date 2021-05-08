package com.lchy._04字符缓冲流;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
    目标：字符缓冲流

     字节流                                        字符流
     字节输入流              字节输出流              字符输入流           字符输出流
     InputStream            OutputStream            Reader              Writer      (抽象类)
     FileInputStream        FileOutputStream        FileReader          FileWriter  (子类实现类)
     BufferedInputStream    BufferedOutputStream    BufferedReader      BufferedWriter(实现类，缓冲流)

    字符缓冲输入流：BufferedReader
            -- 作用：字符缓冲输入流可以把字符输入流包装成一个高级的缓冲字符输入流
                    可以提高字符输入流读数据的性能。
            -- 构造器：public BufferedReader(Reader reader)
            -- 原理：缓冲字符输入流默认会有一个8K的字符缓冲池，可以提高读字符的性能。
            -- 缓冲字符输入流除了提高了字符输入流的读数据性能，还多了一个按照行读取数据的功能（重点）
                public String readLine():读取一行数据返回，读取完毕返回null；
    小结：
        字符缓冲输入流可以把字符输入流包装成一个高级的缓冲字符输入流。
        可以提高字符输入流读数据的性能。
        除此之外多了一个按照行读数据的功能。
            public String readLine():读取一行数据返回，读取完毕返回null；
 */

public class BufferedReaderDemo {
    public static void main(String[] args) {
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader("Day10Demo\\src\\dilei08.txt"));){
            /*int len = 0;
            char[] chars = new char[1024];
            while ((len = bufferedReader.read(chars)) != -1){
                System.out.println(new String(chars,0,len));
            }*/

            /*System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());//最后一行返回null*/

            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
