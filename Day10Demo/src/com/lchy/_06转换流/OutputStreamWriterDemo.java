package com.lchy._06转换流;

import java.io.*;
import java.nio.charset.Charset;

/**
     目标：字符缓冲流

                    字节流                                        字符流
     字节输入流              字节输出流              字符输入流           字符输出流
     InputStream            OutputStream            Reader              Writer      (抽象类)
     FileInputStream        FileOutputStream        FileReader          FileWriter  (子类实现类)
     BufferedInputStream    BufferedOutputStream    BufferedReader      BufferedWriter(实现类，缓冲流)
                                                    InputStreamReader   OutputStreamWriter
     字符输入转换流：OutputStreamWriter
        -- 作用：可以把原始的字节流按照当前默认的代码编码转换成字符输出流
                可以把原始的字节流按照指定编码转换成字符输出流

         -- 构造器：
            public OutputStreamWriter(OutputStream is):可以使用当前代码默认编码转换成字符输出流
            public OutputStreamWriter(OutputStream is，String charset):可以指定编码转换成字符输出流

     小结：
        字符输出转换流可以指定编码把字节输出流按照指定编码转换成字符输出流

 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        try(
                Reader reader = new InputStreamReader(new FileInputStream("Day10Demo\\src\\dilei10.txt"), Charset.forName("GBK"));
                Writer writer = new OutputStreamWriter(new FileOutputStream("Day10Demo\\src\\dilei11.txt"),Charset.forName("GB18030"))){
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                writer.write(line);
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
