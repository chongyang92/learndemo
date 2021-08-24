package com.lchy._11Base64;

import java.util.Base64;
import java.util.UUID;

/** 不会乱码
    目标：https://www.baidu.com/s?ie=UTF-8&wd=%E6%88%91%E6%98%AF

    Base64是网络上最常见的用于传输8bit字节码的编码方式之一，Base64就是一种基于64可打印字符来
    表示二进制数据的方法。

    Base64可以实现编码和解码。
    Java8内置了Base64 编码的编码器和解码器。

    encode:编码
    decode:解码
 */
public class Base64Demo {
    public static void main(String[] args) {
        //1-1.基本编码后结果，普通文本的编码
        String rs1 = Base64.getEncoder().encodeToString("黑马程序员".getBytes());
        System.out.println(rs1);//6buR6ams56iL5bqP5ZGY

        //1-2.基本解码后结果，普通文本的解码
        byte[] buffer = Base64.getDecoder().decode(rs1);
        System.out.println(new String(buffer));

        //2-1.URL编码
        String rs2 = Base64.getUrlEncoder().encodeToString("?loginName=黑马程序员&password=123456".getBytes());
        System.out.println(rs2);

        //2-2.URL解码
        byte[] buffer2 = Base64.getUrlDecoder().decode(rs2);
        System.out.println(new String(buffer2));

        //3-1MIME编码
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(UUID.randomUUID().toString());
        }

        String rs3 = Base64.getMimeEncoder().encodeToString(stringBuilder.toString().getBytes());
        System.out.println(rs3);

        //3-2MIME解码
        byte[] buffer3 = Base64.getMimeDecoder().decode(rs3);
        System.out.println(new String(buffer3));
    }
}
