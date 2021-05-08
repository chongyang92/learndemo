package com.lchy._04字符缓冲流;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
     目标：字符缓冲流

                       字节流                                        字符流
         字节输入流              字节输出流              字符输入流           字符输出流
         InputStream            OutputStream            Reader              Writer      (抽象类)
         FileInputStream        FileOutputStream        FileReader          FileWriter  (子类实现类)
         BufferedInputStream    BufferedOutputStream    BufferedReader      BufferedWriter(实现类，缓冲流)

     字符缓冲输入流：BufferedWriter
            -- 作用：字符缓冲输出流可以把字符输出流包装成一个高级的缓冲字符输出流
     可以提高字符输入流读数据的性能。
             -- 构造器：public BufferedWriter(Writer writer)
             -- 原理：缓冲字符输出流默认会有一个8K的字符缓冲池，可以提高读字符的性能。
             -- 缓冲字符输出流除了提高了字符输出流的读数据性能，还多了一个按照行写取数据的功能（重点）
            public String newLine():读取一行数据返回，读取完毕返回null；
     小结：
         字符缓冲输出流可以把字符输出流包装成一个高级的缓冲字符输出流。
         可以提高字符输出流读数据的性能。
         除此之外多了一个换行的功能。
         public void newLine():新建一行
 */
public class BufferedWriterDemo {
    public static void main(String[] args) {
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Day10Demo\\src\\dilei09.txt"));){
            bufferedWriter.write("hello");
            bufferedWriter.write("java");
            bufferedWriter.newLine();//换行
            char[] chars = new char[]{'a','c','0'};
            bufferedWriter.write(chars);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
