package com.lchy._09文件上传演示;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
     目标：实现客户端上传图片给服务端保存起来

     开发客户端： 本地图片 F:/file/srcIMG_20201116_183806.jpg
     开发服务端： 服务器路径 F:/file/image
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("客户端启动,输入   文件路径：");
        /*Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();*/
        try(//不要关闭socket流
                //1.获取本地图片流
                InputStream inputStream = new FileInputStream("F:/file/srcIMG_20201116_183806.jpg");
                //1.与服务端建立连接
                Socket socket = new Socket("127.0.0.1",7777);
                //2.获取OutputStream流
                OutputStream outputStream = socket.getOutputStream();){

            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(bytes))!= -1){
                bufferedOutputStream.write(bytes,0,len);
                bufferedOutputStream.flush();
            }
            //socket.shutdownOutput();//禁用此套接字的输出流
            System.out.println("图片发送成功！");
            InputStream inputStreamResult = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamResult));
            System.out.println("服务端反馈结果："+bufferedReader.readLine());

            //Thread.sleep(3000);
        }catch (IOException  e){
            e.printStackTrace();
        }

    }
}
