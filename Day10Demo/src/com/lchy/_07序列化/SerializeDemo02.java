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

    对象反序列化流（对象字节输入流）：ObjectInputStream
        -- 作用：读取序列化的对象文件恢复到Java对象中。
        -- 构造器： public ObjectIntputStream(InputStream out)
        -- 序列化方法: public final Object readObject()

    小结：
        如果有变量不想被序列化，加transient关键字
        在User被序列化和反序列化时，不能改变其属性的类型或加关键字，会影响版本号，报错版本不一致
 */
public class SerializeDemo02 {
    public static void main(String[] args) {
        //低级流，FileInputSteam、FileOutputStream
        try(
                FileInputStream fileInputStream = new FileInputStream("Day10Demo\\src\\dilei12.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);){
            User user = (User)objectInputStream.readObject();
            System.out.println(user);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
