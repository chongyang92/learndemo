package com.lchy._02字节缓冲流;

import javax.swing.text.JTextComponent;
import java.io.*;

/**
    目标：字节缓冲输入流的使用

                   字节流                                        字符流
     字节输入流              字节输出流              字符输入流           字符输出流
     InputStream            OutputStream            Reader              Writer      (抽象类)
     FileInputStream        FileOutputStream        FileReader          FileWriter  (子类实现类)
     BufferedInputStream    BufferedOutputStream    BufferedReader      BufferedWriter(实现类，缓冲流)

    a.字节缓冲输入流：BufferedInputStream
            -- 作用：可以把低级的字节输入流包装成一个高级的缓冲字节输入流管道，
                    从而提高字节输入流读数据的性能。
            -- 构造器：public BufferedInputStream(InputStream in)
            -- 原理： 缓冲字节输入流管道自带了一个8KB的缓冲池，每次可以直接借用操作系统的功能最多提取8KB
                    的数据到缓冲池中去，以后我们直接从缓冲池读取数据，所以性能较好！
 */
public class BufferedInputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        //1.定义一个低级的字节输入流与源文件接通
        InputStream inputStream = new FileInputStream("F:\\file\\2020-04-22-01.mp4");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        long begin = System.currentTimeMillis();
        System.out.println(begin);
        //2.定义一个字节数组按照循环读取。
        byte[] bytes = new byte[8*1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1){
            //System.out.println(new String(bytes,0,len));
        }
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("耗时："+ (end - begin));
        /*1617702245048
        1617702245092*/

    }
}
