package com.lchy._07TCP通信四;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
    目标：
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动");
        //1.注册端口
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.使用线程池处理连接
        HandlerSocketThreadPool handlerSocketThreadPool =
                new HandlerSocketThreadPool(3,100);

        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("有人上线了！");
            //每次收到一个客户端的socket请求，都需要为这个客户端分配一个
            // 独立的线程 专门负责对这个客户端的通信！
            handlerSocketThreadPool.execute(new ReaderClientRunnable(socket));
        }

    }
}
