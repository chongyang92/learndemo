package com.lchy._22递归实现文件搜索;

import java.io.File;

/**
    目标：递归实现文件搜索（非规律递归）

    需求：希望去F:/file目录寻找出hello.txt文件

    分析：
        （1）定义一个方法用于做搜索
        （2）进入方法中进行业务搜索分析
 */
public class FileSearchDemo {
    public static void main(String[] args) {
        //搜索调用方法
        String search = search(new File("F:\\file"), "hello.txt");
        System.out.println(search);
    }

    /**
     *
     * @param dir 搜索文件目录
     * @param fileName 搜索文件名称
     * @return
     */
    public static String search(File dir, String fileName){
        String location = "没找到";
        File[] files = dir.listFiles();
        if(files != null && files.length !=0){
            for (File file : files) {
                if(file.isFile()){
                    if(file.getName().equals(fileName)){
                        return "找到了,位置在：" + file.getAbsolutePath();
                    }
                }else if(file.isDirectory()){
                    location = search(file,fileName);
                }
            }
        }

        return location;
    }
}
