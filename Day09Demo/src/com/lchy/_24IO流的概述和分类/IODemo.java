package com.lchy._24IO流的概述和分类;

/**
    目标：IO流读写数据

    IO输入输出流：输入/输出流
        Input:输入
        Output:输出

    引入：
        File类只能操作文件对象本身，不能读写文件对象内容。
        读写数据内容，应该使用IO流。

    IO流是一个水流模型：IO理解成水管，把数据理解成水流。

    IO流的分类：
        按照流的方向分为：输入流，输出流
            （1）输入流：以内存为基准，把内存中的数据写出到磁盘文件或者网络介质中去的流称为输出流
                    输出流的作用：写数据到文件，或者写数据发送给别人。
            （2）输入流：以内存为基准，把磁盘文件中的数据或者网络中的数据读入到内存中去的流，称为输入流
                输入流的作用：读取数据到内存
        按照流的内容分为：字节流，字符流 （流中的内容是二进制还是字符）
            （1）字节流：流中的数据的最小单位是一个一个的字节，这个流就是字节流。--音视频文件
            （2）字符流：流中的数据的最小单位是一个一个的字符，这个流就是字符流。（针对于文本内容）--

     所以流大体分为四大类:
         字节输入流：以内存为基准，把磁盘文件中的数据或者网络中的数据以一个一个的字节的形式读入到内存中去的流称为字节输入流。
         字节输出流：以内存为基准，把内存中的数据以一个一个的字节写出到磁盘文件或者网络介质中去的流称为字节输出流。
         字符输入流：以内存为基准，把磁盘文件中的数据或者网络中的数据以一个一个的字符的形式读入到内存中去的流称为字符输入流。
         字符输出流：以内存为基准，把内存中的数据以一个一个的字符写出到磁盘文件或者网络介质中去的流称为字符输出流。
     小结：
        IO流是读写传输数据的，IO流有很多种，每种流有自己的功能特点。
 */
public class IODemo {
}
