package com.lchy._26字节流做文件复制;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
    目标：字节流做文件复制：jdk1.7释放资源的新形式

    try-with-resources:
        try(
            //这里只能放置资源对象，用完会自动调用close()关闭
        ){

        }catch(Exception e){
            e.printStackTrace();
        }

    什么是资源？
        资源类一定是实现了Closeable接口，实现这个接口的类就是资源
        有close()方法，try-with-resource会自动调用它的close()关闭资源。
    小结：
        字节流很适合做文件数据的复制。
 */
public class CopyDemo02 {
    public static void main(String[] args) {
      /* FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;*/
      try (
              //fileInputStream、fileOutputStream相当于常量
              //这里是小括号，花括号内定义变量，括号外不能访问，小括号内定义变量，外部可以访问
              FileInputStream fileInputStream = new FileInputStream("F:\\file\\2020-04-22-01.mp4");
              FileOutputStream fileOutputStream = new FileOutputStream("F:\\file\\55.mp4");
        ){
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
                fileOutputStream.flush();
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
