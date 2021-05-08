package com.lchy._07序列化;

import java.io.*;

/**
    目标：对象序列化技术。

    对象序列化：就是把Java对象数据直接存储到文件中去。         对象  => 文件中
    对象反序列化：就是把Java对象的文件数据恢复到Java对象中    文件中 => 对象
     字节流                                        字符流
     字节输入流              字节输出流              字符输入流           字符输出流
     InputStream            OutputStream            Reader              Writer      (抽象类)
     FileInputStream        FileOutputStream        FileReader          FileWriter  (子类实现类)
     BufferedInputStream    BufferedOutputStream    BufferedReader      BufferedWriter(实现类，缓冲流)
                                                    InputStreamReader   OutputStreamWriter
     ObjectInputStream      ObjectOutputStream

    对象序列化流（对象字节输出流）：ObjectOutputStream
        -- 作用：把内存中的Java对象数据保存到文件中去
        -- 构造器： public ObjectOutputStream(OutputStream out)
        -- 序列化方法: public final void writeObject(Object obj)

 */
public class SerializeDemo01 {
    public static void main(String[] args) {
        //低级流，FileInputSteam、FileOutputStream

        User user = new User("heima","123456","34");
        try(
                FileOutputStream fileOutputStream = new FileOutputStream("Day10Demo\\src\\dilei12.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);){
            objectOutputStream.writeObject(user);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
