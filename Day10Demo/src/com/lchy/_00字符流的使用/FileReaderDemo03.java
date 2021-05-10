package com.lchy._00字符流的使用;

import java.io.*;
import java.nio.charset.Charset;
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
         字符流按照字符数组循环读取数据，可以解决中文读取输出乱码的问题，而且性能也较好！
 */
public class FileReaderDemo03 {
    public static void main(String[] args)  {
        //文件为GB18030格式，Java默认UTF-8，需要指定为GB18030
        try(Reader reader = new FileReader("Day10Demo/src/dilei05.txt", Charset.forName("GB18030"))){
            char[] chars = new char[1024];
            int len = 0;
            while ((len = reader.read(chars)) != -1){
                System.out.println(new String(chars,0,len));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
