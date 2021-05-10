package com.lchy._00字符流的使用;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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
         public FileWriter(File file):创建一个字符输入流与源文件对象接通。
         public FileWriter(String filePath):创建一个字符输入流与源文件路径接通。
         public FileWriter(File file,Boolean ap):创建一个字符输入流与源文件对象接通。
         public FileWriter(String filePath,Boolean ap):创建一个字符输入流与源文件路径接通。
         public FileWriter(File file,Charset c):创建一个字符输入流与源文件对象接通。
         public FileWriter(String filePath,Charset c):创建一个字符输入流与源文件路径接通。
        -- 方法：
         public int write():写一个字符出去
         public int write(String str):写一个字符串出去
         public int write(char[] buffer):写一个字符数组出去
         public int write(String str, int pos, int len):写字符串的一部分出去
         public int write(char[] buffer, int pos, int len):写一个字符数组一部分出去
    小结：
        字符输出流可以写字符数据出去，总共由5个方法写字符。
        覆盖管道：
            Write fw = new FileWrite("Day10Demo/src/dilei06.txt"); //覆盖数据管道
        追加数据管道：
            Write fw = new FileWrite("Day10Demo/src/dilei06.txt", true); //覆盖数据管道
        换行：
            writer.write("\r\n"); //换行
        读写字符文件数据建议使用字符流。
 */
public class FileWriterDemo04 {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("Day10Demo/src/dilei06.txt", Charset.forName("GBK"),true)){
            writer.write(97);
            writer.write('b');
            writer.write('磊');
            writer.write("\r\n");

            writer.write("Java是最优美的语言！");
            writer.write("\r\n");

            writer.write("我爱中国".toCharArray());
            writer.write("\r\n");

            char[] chars = {97,98,100};
            writer.write(chars);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
