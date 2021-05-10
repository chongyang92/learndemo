package com.lchy._25字节流的使用;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

/**
    目标：
     IO流的体系：
     字节流                                   字符流
     字节输入流          字节输出流              字符输入流     字符输出流
     InputStream        OutputStream            Reader         Writer      (抽象类)
     FileInputStream    FileOutputStream        FileReader     FileWriter  (子类实现类)

    a.FileOutputStream文件字节输出流
        -- 作用：以内存为基准，把内存数据按照字节写出到磁盘文件中去。
                简单来说，把内存数据按照字节写出到磁盘文件中去。
        -- 构造器：
            public FileOutputStream(File file):创建一个字节输出流管道通向目标文件对象。
            public FileOutputStream(String file):创建一个字节输出流管道通向目标文件路径。
            public FileOutputStream(File file, boolean append):创建一个追加数据的字节输出流
            public FileOutputStream(String file, boolean append):创建一个追加数据的字节输出流
        -- 方法：
            public void write(int a):写一个字节出去。
            public void write(byte[] buffer):写一个字节数组出去。
            public void write(byte[] buffer, int pos, int len):写一个字节数组的一部分出去
                            参数一，字节数组；参数二，起始字节索引位置，参数三，写出多少个字节数出去
    小结：
        字节输出流可以写字节数据到文件中去。
        写一个字节，写一个字节数组，写一个字节数组的一部分出去
        管道用完需要关闭，数据要生效需要刷新，关闭包含书信，刷新后流可以继续使用，关闭后流无法继续使用
        字节输出流管道默认是覆盖数据管道，启动管道写数据前会清空数据
                FileOutputStream os = new FileOutputStream("Day09Demo/src/dilei04.txt");
        追加数据管道，第二个参数是true即可
                FileOutputStream os = new FileOutputStream("Day09Demo/src/dilei04.txt",true);
 */
public class OutputStreamDemo04 {
    public static void main(String[] args) throws Exception {
        /*//1.创建一个文件对象定位目标文件（写数据到文件，文件会自动创建）
        File file = new File("Day09Demo/src/dilei04.txt");
        //2.创建一个字节输出流管道于目标文件对象接通
        FileOutputStream fileOutputStream = new FileOutputStream(file);*/
        //3.简化写法：创建一个字节输出流管道于目标文件对象接通
        FileOutputStream os = new FileOutputStream("Day09Demo/src/dilei04.txt",true);
        //4.写数据出去
        //a.写一个字节出去（写一滴水出去）
        os.write(97);
        os.write('b');
        //os.write((short)78);//低位的一个字节，把78当作
        //os.write(255);
        //os.write('磊');//[ooo]只会写出中文的第一个字节，写出去就乱码！

        //b.写一个字节数组出去（写一个桶出去）
        byte[] bytes = new byte[]{98,99,100,111,104};
        os.write(bytes);
        String str = "hello java";
        os.write(str.getBytes());
        //byte[] bytes1 = "java 是最优美的语言".getBytes("GBK");
        byte[] bytes1 = "java 是最优美的语言".getBytes();//默认以当前代码编码UTF-8提取字节数组
        os.write(bytes1);

        os.write("\r\n".getBytes());

        //c.写一个字节数组的一部分出去
        byte[] bytes2 = "java是最优美的语言".getBytes();
        os.write(bytes2,0,19);


        //os.flush();//立即刷新数据到文件中去.刷新后管道可以继续使用
        os.close();//关闭资源管道，关闭包含了刷新，关闭后管道不能使用。
    }
}
