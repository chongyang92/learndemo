package com.lchy._18File类的判断功能的方法;

import java.io.File;

/**
    目标：File类的判断功能的方法
        -public boolean exists():此File表示的文件或目录是否实际存在
        -public boolean isDirectory():此File表示的是否为目录
        -public boolean isFile():此File表示的是是否为文件
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("F:\\file\\IMG_20201116_183806.jpg");
        //a.判断文件路径是否存在
        System.out.println(file.exists());
        //b.判断文件对象是否是文件，是文件返回true，反之
        System.out.println(file.isFile());
        //c.判断文件对象是否为目录
        System.out.println(file.isDirectory());
    }
}
