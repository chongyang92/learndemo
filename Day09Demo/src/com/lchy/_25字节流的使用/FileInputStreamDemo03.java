package com.lchy._25字节流的使用;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
    目标：解决字节输入流读取中文内容输入乱码的问题。

    引入：
        一个一个字节读取中文输出
        一个一个字节数组读取中文输出均无法避免乱码。
    如何实现读取可以避免乱码呢？
        1.定义一个字节数组与文件的大小刚刚一样大，然后一桶读取全部字节数据再输出！
 */
public class FileInputStreamDemo03 {
    public static void main(String[] args) throws IOException {
        //1.定义一个字节输入流通向源文件路径，简化写法
        File file = new File("Day09Demo\\src\\dilei03.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        /*int len = 0;
        byte[] bytes = new byte[(int) file.length()];
        while ((len = fileInputStream.read(bytes)) != -1){
            System.out.print(new String(bytes,0,len));
        }*/

        byte[] bytes1 = fileInputStream.readAllBytes();
        System.out.println(new String(bytes1));
    }
}
