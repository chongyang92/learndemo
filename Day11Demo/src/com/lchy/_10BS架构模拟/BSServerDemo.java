package com.lchy._10BS架构模拟;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
    目标：BS-浏览器-服务器基本了解

    引入：
        之前客户端和服务器都需要自己开发，也就是CS架构。

    客户端：浏览器（无需开发）
    服务端：自己开发
    需求：在浏览器中请求本程序，响应一个网页文字给浏览器显示。
 */
public class BSServerDemo {
    public static void main(String[] args) {
        try{
            //1.注册端口
            ServerSocket serverSocket = new ServerSocket(8080);
            //2.创建一个循环接收多个客户端的请求。
            while (true){
                Socket socket = serverSocket.accept();
                new ServerReaderThread(socket).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class ServerReaderThread extends Thread{
    private Socket socket;
    public ServerReaderThread(){
    }
    public ServerReaderThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //响应消息给浏览器显示
            //浏览器是基于HTTP协议通信！响应格式必须满足HTTP数据格式的要求，浏览器
            //才能够识别，否则响应消息浏览器根本不认识。
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("HTTP/1.1 200 OK");//响应数据的响应头数据！
            printStream.println("Content-Type:text/html;charset=UTF-8");//响应数据的类型，网页或者文本内容！
            printStream.println();//必须换一行，代表响应结束
            //一下开始响应真实的数据！
            printStream.println("<span style='color:green;font-size:60px;'>前端浏览器，后端返回的数据</span>");
            Thread.sleep(3000);
            printStream.close();
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
