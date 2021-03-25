package com.lchy._19File类的创建和删除的方法;

import java.io.File;
import java.io.IOException;

/**
    目标：File类的创建和删除的方法
        -public boolean createNewFile():当且仅当具有该名称的文件尚不存在时
                创建一个新的空文件（几乎不用的，因为以后文件都是自动创建的）
        -public boolean delete():删除由此File表示的文件或目录（只能删除空目录）
        -public boolean mkdir():创建由此File表示的目录（只能创建一级目录）
        -public boolean mkdirs():可以创建多级目录（建议使用的）
*/
public class FileDemo {
    public static void main(String[] args) throws IOException {
        //a.创建新文件，创建成功返回true，反之
        File file = new File("Day09Demo/src/dilei02.txt");
        System.out.println(file.createNewFile());
        //b.删除文件或空文件夹
        System.out.println(file.delete());
        //不能删除非空文件夹，只能删除空文件夹
        File file1 = new File("F:\\file");
        System.out.println(file1.delete());
        //c.创建一级目录
        File file2 = new File("F:\\file\\haha");
        file2.mkdir();
        //d.创建多级目录
        File file3 = new File("F:\\file\\haha\\hehe\\heihei");
        file3.mkdirs();
    }
}
