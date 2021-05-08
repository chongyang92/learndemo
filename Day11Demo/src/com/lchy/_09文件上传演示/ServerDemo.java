package com.lchy._09文件上传演示;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

/**
    目标：实现客户端上传图片给服务端保存起来

    开发客户端： 本地图片 F:/file/IMG_20201116_183806.jpg
    开发服务端： 服务器路径 F:/file/image
 */
public class ServerDemo {
    public static void main(String[] args) {
        System.out.println("服务器启动");
        try(//1.注册端口
            ServerSocket serverSocket = new ServerSocket(7777);){

            //2.线程池
            MyHandlerSocketThreadPool myHandlerSocketThreadPool =
                    new MyHandlerSocketThreadPool(3,100);
            //2.接入连接
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("接入");
                myHandlerSocketThreadPool.execute(new MyReaderClientRunnable(socket));
            }

        }catch (IOException  e){
            e.printStackTrace();
        }
    }
}
