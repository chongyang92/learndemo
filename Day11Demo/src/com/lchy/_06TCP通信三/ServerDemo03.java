package com.lchy._06TCP通信三;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
    目标：开发服务器。
        1.注册端口。
        2.接收客户端的Scoket管道连接。
        3.从socket通信管道中得到一个字节输入流
        4.从字节输入流中读取客户端发来的数据。

    ServerSocket类：
        构造器： public ServerSocket(int port)
        方法： public Socket accept()
            --等待接收一个客户端的Socket管道连接请求，连接成功返回一个Socket对象

    需求：客户端发送一行数据，服务端接收一行数据！！
    小结：
        1.客户端用Socket连接服务端
        2.服务端用ServerSocket注册端口，接收客户端的Socket连接
        3.通信是很严格的，对方怎么发，你就应该怎么受，对方发多少你就只能收多少。
        4.实现的面向连接的socket端到端的通信管道，一方如果出现问题，另一方会出现异常
*/
public class ServerDemo03 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动");
        //1.注册端口
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.定义一个循环不断的接收客户端的连接请求
        while (true) {
            //3.开始等待接收客户端Socket管道连接。
            Socket socket = serverSocket.accept();
            //4.每接收到一个客户端必须为这个客户端管道分配一个独立的线程来处理与之通信。
            new ServerReaderThread(socket).start();
        }
    }
}

class ServerReaderThread extends Thread{
    private Socket socket;
    public ServerReaderThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //3.从socket通信管道中得到一个字节输入流
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();

            //4.把字节输入流转换成字符输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //5.按照行读取消息
            String line = null;
            //外部while没有机会继续往下走
            while ((line = bufferedReader.readLine()) != null) {//客户端要按行发
                System.out.println(socket.getRemoteSocketAddress()+line);
            }
        } catch (IOException e) {
            System.out.println("有人下线了");
            e.printStackTrace();
        }

    }
}
