package com.lchy._20File目录的遍历;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
    目标：File针对目录的遍历
        -public String[] list():
            获取当前目录下所有的“一级文件名称”到一个字符串数组中去返回。
        -public File[] listFiles() (常用)：
            获取当前目录下所有的“一级文件对象”到一个文件对象数组中去返回（重点）
        -public long lastModified()
            获取文件最后修改时间
 */
public class FileDemo {
    public static void main(String[] args) {
        File dir = new File("F:\\file");
        String[] fileList = dir.list();
        for (String fileName : fileList) {
            System.out.println(fileName);
        }

        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }

        //拓展
        File file = new File("F:\\file\\IMG_20201116_183806.jpg");
        long time = file.lastModified();//最后修改时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(time));
    }
}
