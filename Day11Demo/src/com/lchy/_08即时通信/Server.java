package com.lchy._08即时通信;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
    目标：
 */
public class Server {
    public static Map<String,Socket> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        //维护一个好友列表


        System.out.println("服务端启动");
        //1.注册端口
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.使用线程池处理连接
        HandlerSocketThreadPool handlerSocketThreadPool =
                new HandlerSocketThreadPool(3,100);
        int num = 0;
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("有人上线了！");
            //map.put(socket,Integer.toString(num++));
            // 每次收到一个客户端的socket请求，都需要为这个客户端分配一个
            // 独立的线程 专门负责对这个客户端的通信！
            handlerSocketThreadPool.execute(new ReaderClientRunnable(socket,map));
        }

    }
}
