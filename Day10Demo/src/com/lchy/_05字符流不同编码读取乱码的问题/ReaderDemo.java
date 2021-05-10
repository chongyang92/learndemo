package com.lchy._05字符流不同编码读取乱码的问题;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

/**
    目标：字符流不同编码读取乱码的问题。
    引入：
        我们之前用的代码编码和文件编码都是UTF-8编码，字符流读取没有出现乱码！
        字符流读取：
            代码编码                文件编码         中文情况
            UTF-8                   GBK             不乱码
            GBK                     GBK             不乱码
            UTF-8                   GBK             乱码
    小结：
        如果代码编码和读取的文件编码一致，字符流读取的时候不会乱码。
        如果代码编码和读取的文件编码不一致，字符流读取的时候会乱码。
 */
public class ReaderDemo {
    public static void main(String[] args) {
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader("Day10Demo\\src\\dilei10.txt", Charset.forName("GBK")));){

            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
