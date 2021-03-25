package com.lchy._25字节流的使用;

import java.io.*;

/**
    目标：字节输入流的使用

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
    小结：
        一个一个字节读取英文和数字没有问题
        但是一旦读取中文输出无法避免乱码，因为会截断中文的字节。
        一个一个字节的读取数据，性能也较差，所以禁止使用此方案
 */
public class FileInputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        //1.创建文件对象定位dilei01.txt
        File file = new File("Day09Demo/src/dilei01.txt");
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
        int ch = 0;
        while ((ch = fileInputStream.read() )!= -1){
            System.out.println((char) ch);
        }
    }
}
