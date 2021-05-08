package com.lchy._00字符流的使用;



import sun.nio.cs.StreamDecoder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_16;
import static java.nio.charset.StandardCharsets.UTF_8;
//import java.util.function.BinaryOperator;
//import java.util.stream.Stream;


/**
    目标：字符输入流的使用

     IO流的体系：
     字节流                                   字符流
     字节输入流          字节输出流              字符输入流     字符输出流
     InputStream        OutputStream            Reader         Writer      (抽象类)
     FileInputStream    FileOutputStream        FileReader     FileWriter  (子类实现类)

    c.FileReader:文件字符输入流
        -- 作用：以内存为基准，把磁盘文件的数据以字符的形式读入到内存。
            简单来说，读取文本文件内容到内存中去。
        -- 构造器：
            public FileReader(File file):创建一个字符输入流与源文件对象接通。
            public FileReader(String filePath):创建一个字符输入流与源文件路径接通。
        -- 方法：
            public int read():读取一个字符的编号返回！读取完毕返回-1
            public int read(char[] buffer):读取一个字符数组，读取多少个字符就返回多少个数量
    小结：
        字符流一个一个字符的读取文本内容输出，可以解决中文读取输出乱码的问题
        字符流很适合操作文本文件内容。
        但是：一个一个字符的读取文本内容性能较差！
 */
public class FileReaderDemo02 {
    public static void main(String[] args) throws Exception {
        //3.简化写法：创建一个字符输入流管道与源文件路径接通
        Reader reader = new FileReader("Day10Demo/src/dilei01.txt");

        int len = 0;
        char[] chars = new char[1024];
        StringBuilder aa = new StringBuilder();
        while ((len = reader.read(chars)) != -1){
            System.out.println(new String(chars,0,len));
            System.out.println("+++++++++++++++++"+len);
        }
        System.out.println(Integer.toBinaryString(chars[0]));
        System.out.println(Integer.toBinaryString(chars[1]));
        System.out.println(Integer.toBinaryString(chars[2]));
        //UTF-8: 11110000 10100000 10000011 10010111
        //           000010 00000000 11010111
        //11011000 01000000 11011100 11010111
        System.out.println(Integer.toHexString(chars[0]));
        System.out.println(Integer.toHexString(chars[1]));

        reader.close();

        /*FileOutputStream fileOutputStream = new FileOutputStream("Day10Demo/src/dilei02.txt");
        byte b1 = (byte)(0xff & chars[0]);
        byte b2 = (byte)((0xff00 & chars[0]) >> 8);
        byte b3 = (byte)(0xff & chars[1]);
        byte b4 = (byte)((0xff00 & chars[1]) >> 8);
        byte[] fileOutputStreamByte = {b1, b2, b3, b4};

        fileOutputStream.write(fileOutputStreamByte);
        fileOutputStream.flush();
        fileOutputStream.close();*/

        //默认写出文件编码为UTF-8
        FileWriter fileWriter = new FileWriter("Day10Demo/src/dilei05.txt",Charset.forName("GB18030"));
        //FileWriter fileWriter = new FileWriter("Day10Demo/src/dilei02.txt");

        fileWriter.write(chars,0,2);
        fileWriter.flush();
        fileWriter.close();

        System.out.println("磊".codePoints().count());
        System.out.println("𠃗".codePoints().count());
        "𠃗".codePoints().forEach(System.out::println);
        System.out.println("𠃗".codePointAt(0));
    }
}
