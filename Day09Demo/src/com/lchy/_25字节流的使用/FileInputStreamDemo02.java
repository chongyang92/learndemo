package com.lchy._25字节流的使用;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
    目标：字节输入流的使用-按照字节数组读取

    IO流的体系：
               字节流                                   字符流
    字节输入流          字节输出流              字符输入流     字符输出流
    InputStream        OutputStream            Reader         Writer      (抽象类)
    FileInputStream    FileOutputStream        FileReader     FileWriter  (子类实现类)

    a.FileInputStream文件字节输入流
        -- 作用：以内存为基准，把磁盘文件中的数据按照字节的形式读入到内存中的流。
                简单来说，就是按照字节读取文件数据到内存。
        -- 构造器：
            1.public FileInputStream(File path):创建一个字节输入流管道与源文件对象接通。
            2.public FileInputStream(String pathName):创建一个字节输入流管道与文件路径对接。
        -- 方法：
            1.public int read():每次读取一个字节返回！读取完毕会返回-1.
            2.public int read(byte[] buffer):从字节输入流中读取字节到数组中去。
                返回读取的字节数量，没有字节可读返回-1
    小结：
        使用字节数组读取内容，效率可以
        但是使用字节数组读取文本内容输出，也无法避免中文读取输入乱码的问题。

 */
public class FileInputStreamDemo02 {
    public static void main(String[] args) throws IOException {
        //1.创建文件对象定位dilei01.txt
        File file = new File("Day09Demo/src/dilei02.txt");
        //2.创建一个字节输入流管道与源文件接通
        FileInputStream fileInputStream = new FileInputStream(file);
        //3.读取一个字节的编号返回，读取完毕返回-1
        /*int code1 = fileInputStream.read();//读取一滴水，一个字节
        System.out.println((char) code1);
        int code2 = fileInputStream.read();//读取一滴水，一个字节
        System.out.println((char) code2);
        int code3 = fileInputStream.read();//读取一滴水，一个字节
        System.out.println((char) code3);
        int code4 = fileInputStream.read();//读取一滴水，一个字节
        System.out.println((char) code4);*/

        //4.使用while读取字节数
        //定义一个整数变量存储字节
        /*int ch = 0;
        while ((ch = fileInputStream.read() )!= -1){
            System.out.println((char) ch);
        }*/

        //5.定义一个字节数组读取数据（定义一个桶）
        /*byte[] bytes1 = new byte[3];
        //从fileInputStream管道中读取字节装入到字节数组中，
        int len1 = fileInputStream.read(bytes1);
        System.out.println(new String(bytes1));

        byte[] bytes2 = new byte[3];
        //从fileInputStream管道中读取字节装入到字节数组中，
        int len2 = fileInputStream.read(bytes2);
        System.out.println(new String(bytes2));

        byte[] bytes3 = new byte[3];
        //从fileInputStream管道中读取字节装入到字节数组中，
        int len3 = fileInputStream.read(bytes3);
        System.out.println(new String(bytes3,0,len3));*/

       int len = 0;
       byte[] bytes = new byte[3];
       while ((len = fileInputStream.read(bytes)) != -1){
           //读取了多少就倒多少
           System.out.print(new String(bytes,0,len));
       }

    }
}
