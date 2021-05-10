package com.lchy._00编程思维题目;

import java.io.*;

/**
    目标：复制文件夹（面试拓展）
 */
public class CopyDirDemo02 {
    public static void main(String[] args) {
        copyFolder(new File("F:\\file\\src"),new File("F:\\file\\dest"));
    }

    /**
     * 复制文件夹
     * @param srcDir
     * @param destDir
     */
    public static void copyFolder(File srcDir, File destDir){
        if(!srcDir.exists()){
            System.out.println("源文件夹不存在");
        }
        //如果是文件
        if(srcDir.isFile()){
            copyFile(srcDir,destDir);
        //如果是文件夹
        }else if(srcDir.isDirectory()){
            destDir.mkdirs();//创建文件夹
            File[] files = srcDir.listFiles();
            if(files != null && files.length != 0){
                for (File file : files) {
                    copyFolder(file,new File(destDir+"//"+file.getName()));
                }
            }
        }
    }

    /**
     * 拷贝文件
     * @param srcFile      源文件路径   F:/file/src/text/aa.txt
     * @param destFile    目的文件路径  F:/file/dest/text/aa.txt   要具体到文件名
     */
    private static void copyFile(File srcFile, File destFile) {
        try(
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFile));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFile))){
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(bytes))!= -1){
                bufferedOutputStream.write(bytes,0,len);
                bufferedOutputStream.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
