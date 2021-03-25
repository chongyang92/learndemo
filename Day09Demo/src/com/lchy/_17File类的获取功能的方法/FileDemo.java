package com.lchy._17File类的获取功能的方法;

import java.io.File;

/**
    目标：File类的获取功能的API
        -public String getAbsolutePath() : 返回此File的绝对路径名字符串。
        -public String getPath() : 获取创建文件对象的时候用的路径
        -public String getName() : 返回由此File表示的文件或目录的名称。
        -public long length() : 返回由此File表示的文件的长度。
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("F:\\file\\IMG_20201116_183806.jpg");
        //File file = new File("F:\\file");
        //a.获取绝对路径
        System.out.println(file.getAbsolutePath());//绝对路径，文件或文件夹的全路径
        //b.获取创建文件时使用的路径
        System.out.println(file.getPath());
        //c.获取文件的名称：带后缀
        System.out.println(file.getName());//文件名或者文件夹名
        //d.获取文件的大小：字节个数
        System.out.println(file.length());//文件长度，或文件夹长度一般是4096

        System.out.println("-----------------");

        //2.相对路径
        File file1 = new File("Day09Demo/src/dilei01.txt");
        //a.获取绝对路径
        System.out.println(file1.getAbsolutePath());//绝对路径，文件或文件夹的全路径
        //b.获取创建文件时使用的路径
        System.out.println(file1.getPath());
        //c.获取文件的名称：带后缀
        System.out.println(file1.getName());//文件名或者文件夹名
        //d.获取文件的大小：字节个数
        System.out.println(file1.length());//文件长度，或文件夹长度一般是4096
    }
}
