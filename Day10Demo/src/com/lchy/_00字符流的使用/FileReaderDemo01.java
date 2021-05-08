package com.lchy._00字符流的使用;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

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
public class FileReaderDemo01 {
    public static void main(String[] args) throws Exception {
        System.out.println("--------字节流以字节为单位直接从文件中取出字节，编码格式为UTF-8-----------");
        FileInputStream inputStream = new FileInputStream("Day10Demo/src/dilei01.txt");
        byte[] bytes1 = new byte[1];
        byte[] bytes2 = new byte[10];
        int j = 0;
        int num = 0;
        while (inputStream.read(bytes1) != -1){
            String str = Integer.toBinaryString(bytes1[0]);
            System.out.println(str.length() > 8 ? str.substring(24,32) : str);

            bytes2[j++] = bytes1[0];
        }

        switch (j){
            case 1:
                //UTF-8是1个字节
                num = (0xff & bytes2[0]);
                break;
            case 2:
                //UTF-8是2个字节
                num = (0xff & bytes2[0]) << 8 | (0xff & bytes2[1]);
                break;
            case 3:
                //UTF-8是3个字节
                num = (0xff & bytes2[0]) << 16 | (0xff & bytes2[1]) << 8 | (0xff & bytes2[2]);
                break;
            case 4:
                //UTF-8是4个字节
                num = (0xff & bytes2[0]) << 24 | (0xff & bytes2[1]) << 16 | (0xff & bytes2[2]) << 8 | (0xff & bytes2[3]);
                break;
        }

        System.out.println("toBinaryString: "+Integer.toBinaryString(num));
        //char只有两个字节的空间
        //char cc = (char)num;
        System.out.println(Integer.toHexString(num).toUpperCase());
        //𠃗 11110000 10100000 10000011 10010111
        inputStream.close();
        System.out.println("------------上面是字节流------------------");
        /*//1.创建一个文件对象定位源文件
        File file = new File("Day10Demo/src/dilei01.txt");
        //2.创建一个字符输入流管道与源文件接通
        FileReader fileReader = new FileReader(file);*/
        //3.简化写法：创建一个字符输入流管道与源文件路径接通
        Reader reader = new FileReader("Day10Demo/src/dilei01.txt");
        //4.按照字符读取，每次读取一个字符的编号返回
        /*int code1 = reader.read();
        System.out.println((char)code1);
        int code2 = reader.read();
        System.out.println((char)code2);
        int code3 = reader.read();
        System.out.println((char)code3);
        int code4 = reader.read();
        System.out.println(code4);*/
        //dμ磊𠃗
        int c,i= 0;
        StringBuilder aa = new StringBuilder();
        while ((c = reader.read()) != -1){
            System.out.println("ch:toBinaryString " + Integer.toBinaryString(c));
            System.out.println("ch:toHexString " + Integer.toHexString(c).toUpperCase());
            char ch = (char)c;
            System.out.println(i++ +":"+ch);
            System.out.println("c: "+(0xffffffff & c));
            System.out.println("ch: "+(0xffffffff & ch));

            byte[] bytes = String.valueOf(ch).getBytes();
            System.out.println("len: "+bytes.length);
            for (byte aByte : bytes) {
                String str = Integer.toBinaryString(aByte);
                System.out.println(str.length() > 8 ? str.substring(24,32) : str);
            }

            System.out.println(aa.append(ch));
            System.out.println("+++++++++++++++++");
        }

        reader.close();

        //默认写出文件编码为UTF-8
        FileWriter fileWriter = new FileWriter("Day10Demo/src/dilei05.txt", Charset.forName("UTF-8"));
        //FileWriter fileWriter = new FileWriter("Day10Demo/src/dilei02.txt");

        char[] chars1 = Arrays.toString("中".getBytes("GBK")).toCharArray();
        System.out.println(chars1[0]);
        //fileWriter.write(chars,0,2);
        fileWriter.flush();
        fileWriter.close();
    }
}
