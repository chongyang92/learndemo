package com.lchy._08打印流;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
    目标：打印流PrintStream(基于缓冲流) / PrintWriter

                    字节流                                        字符流
     字节输入流              字节输出流              字符输入流           字符输出流
     InputStream            OutputStream            Reader              Writer      (抽象类)
     FileInputStream        FileOutputStream        FileReader          FileWriter  (子类实现类)
     BufferedInputStream    BufferedOutputStream    BufferedReader      BufferedWriter(实现类，缓冲流)
                                                    InputStreamReader   OutputStreamWriter
     ObjectInputStream      ObjectOutputStream
                            PrintStream                                 PrintWriter

    打印流的作用：
        1.可以方便，快速的写数据出去。
        2.可以实现打印啥出去，就是啥出去
    打印流的构造器：
        public PrintStream(OutputStream os)
        public PrintStream(String filepath)

    小结：
        打印流可以方便且高效的打印各种数据；
 */
public class PrintStreamDemo01 {
    public static void main(String[] args) {

        try(
                //PrintStream printStream = new PrintStream(new FileOutputStream("Day10Demo\\src\\dilei10.txt"));){
                //PrintStream printStream = new PrintStream("Day10Demo\\src\\dilei10.txt");){
                PrintWriter printWriter = new PrintWriter("Day10Demo\\src\\dilei10.txt");){
            /*printStream.print(97);
            printStream.print("Java");
            printStream.print("你好");

            printStream.write(99);//可以直接写字节出去*/

           printWriter.print(98);
           printWriter.println();
           printWriter.print("你好");
           printWriter.print('a');

           printWriter.write("可以写字符数组出去");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
