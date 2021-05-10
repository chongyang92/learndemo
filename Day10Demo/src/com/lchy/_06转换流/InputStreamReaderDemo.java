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
     字符输入转换流：InputStreamReader
        -- 作用：可以把原始的字节流按照当前默认的代码编码转换成字符输入流
                可以把原始的字节流按照指定编码转换成字符输入流

         -- 构造器：
            public InputStreamReader(InputStream is):可以使用当前代码默认编码转换成字符输入流
            public InputStreamReader(InputStream is，String charset):可以指定编码转换成字符输入流

     小结：

     public String readLine():读取一行数据返回，读取完毕返回null；
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        try(
                Reader reader = new InputStreamReader(new FileInputStream("Day10Demo\\src\\dilei10.txt"), Charset.forName("GBK"));){
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
