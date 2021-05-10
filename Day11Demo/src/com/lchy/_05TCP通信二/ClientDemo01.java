package com.lchy._05TCP通信二;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
    目标：客户端可以反复发送数据，服务端可以反复接收数据！

    分析：
        只需要让客户端通过循环进行数据的发送。

    产生的问题：
        目前服务端只能接收一个客户端请求。

    TCP/IP ==> Transfer Control Protocol ==> 传输控制协议

    TCP协议的特点
        * 面向连接的协议
        * 只能由客户端主动发送数据给服务端，服务器端收到数据之后，可以给客户端响应数据。
        * 通过三次握手建立连接，连接成功形成数据传输通道。
        * 通过四次挥手断开连接。
        * 基于IO流进行数据传输
        * 传输数据大小没有限制
        * 因为面向连接的协议，速度慢，但是可靠的协议

    TCP协议的使用场景
        * 文件上传和下载
        * 邮件发送和接收
        * 远程登陆

    TCP相关的类
        * Socket
            * 一个该类的对象就代表一个客户端程序。
        * ServerSocket
            * 一个该类的对象就代表一个服务器端程序。
    TCP通信也叫Socket网络编程，只要代码基于Socket开发，底层就是基于了可靠传输的
    TCP通信。

    Socket类构造器
        * Socket(String host, int port)
        * 根据ip地址字符串和端口号创建客户端Socket对象。
        * 注意事项： 只要执行该方法，就会立即连接指定的服务器程序，如果连接不成功，则会抛出异常。
        如果连接成功，则表示三次握手通过。

    Socket类常用方法
        * OutputStream getOutputStream(); 获得字节输出流对象
        * InputStream getInputStream(); 获得字节输入流对象

    客户端的开发流程：
        1.客户端要求请求于服务端的socket管道连接。
        2.从socket通信管道中得到一个字节输出流
        3.通过字节输出流给服务端写出数据
    服务端的开发流程：
        1.注册客户端
        2.接收客户端的socket管道连接
        3.从socket通信管道中得到一个字节输入流
        4.从字节输入流中读取客户端发来的数据。
 */
public class ClientDemo01 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动");
        //1. 客户端要请求于服务端的socket管道连接。
        //Socket(String host, int port)
        Socket socket = new Socket("192.168.43.91",8888);
        //2.从socket通信管道中得到一个字节输出流
        OutputStream outputStream = socket.getOutputStream();
        //3.通过字节输出流给服务端写出数据
        PrintStream printStream = new PrintStream(outputStream);
        //4.发消息出去

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入消息：");
            printStream.println(scanner.nextLine());
            printStream.flush();
        }
    }
}
