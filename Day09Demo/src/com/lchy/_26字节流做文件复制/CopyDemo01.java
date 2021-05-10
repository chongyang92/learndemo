package com.lchy._26字节流做文件复制;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
    目标：字节流做文件复制

    字节流复制的思想：
        字节是计算机中一切文件的组成，所以
        字节流适合做一切文件的复制
        复制是把源文件的全部字节一字不漏的转移到目标文件，只要文件前后的格式一样，绝对不会有问题。

    需求：
        原文件：F:\file\JAVA核心面试知识整理.pdf
        目标文件：F:\file\面试.pdf
    分析步骤：
        （1）创建一个字节输入流管道与源文件接通。
        （2）创建一个字节输出流与目标文件接通。
        （3）创建一个字节数组作为桶。
        （4）从字节输入流管道中读取数据，写出到字节输出流管道即可。
        （5）关闭资源

    小结：
        字节流很适合做文件数据的复制。
 */
public class CopyDemo01 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("F:\\file\\2020-04-22-01.mp4");
            fileOutputStream = new FileOutputStream("F:\\file\\55.mp4");

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
                fileOutputStream.flush();
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileInputStream != null ){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
