package com.lchy._03字节缓冲流的性能统计分析;

import java.io.*;

/**
    目标：利用字节流的复制统计各种写法形式下缓冲流的性能执行情况

    复制流：
        （1）使用低级的字节流按照一个一个字节的形式复制文件。
        （2）使用低级的字节流按照一个一个字节数组的形式复制文件。
        （3）使用高级的缓冲字节流按照一个一个字节的形式复制文件。
        （4）使用高级的缓冲字节流按照一个一个字节数组的形式复制文件。

 */
public class CopyDemo {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        //oneByte();
        //byteArray();//417ms
        //bufferedOneByte();//1004ms
        bufferedByteArray();//116ms
        long end = System.currentTimeMillis();
        System.out.println((end - begin) + "ms");
    }

    public static void oneByte(){
        try(
                FileInputStream fileInputStream = new FileInputStream("F:\\file\\2020-04-22-01.mp4");
                FileOutputStream fileOutputStream = new FileOutputStream("F:\\file\\55.mp4")){
            int b = 0;

            while ((b = fileInputStream.read()) != -1){
                fileOutputStream.write(b);
                fileOutputStream.flush();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void byteArray(){
        try(
                FileInputStream fileInputStream = new FileInputStream("F:\\file\\2020-04-22-01.mp4");
                FileOutputStream fileOutputStream = new FileOutputStream("F:\\file\\55.mp4")){
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
                fileOutputStream.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void bufferedOneByte(){
        try(
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("F:\\file\\2020-04-22-01.mp4"));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("F:\\file\\55.mp4"))){
            int b = 0;
            while ((b = bufferedInputStream.read()) != -1){
                bufferedOutputStream.write(b);
                bufferedOutputStream.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void bufferedByteArray(){
        try(
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("F:\\file\\2020-04-22-01.mp4"));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("F:\\file\\55.mp4"))){
            int len = 0;
            byte[] bytes = new byte[40*1024];
            while ((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
