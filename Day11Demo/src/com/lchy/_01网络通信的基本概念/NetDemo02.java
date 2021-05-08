package com.lchy._01网络通信的基本概念;

/**
    目标：网络通信的三要素。

    1.协议
        协议：计算机网络客户端与服务端通信必须事先约定和彼此遵守的通讯规则。
        01010000111000111001   前8个代表报文长度，后面是交易码...
        HTTP , FTP , TCP , UDP , SSH , SMTP
        HTTP：浏览器 图片视频文本等显示规则
        FTP：文件上传下载
        TCP：可靠传输，底层
        UDP：不安全传输
        SSH：和服务器Linux交互协议
        SMTP：邮件发送

    2.IP地址：指互联网协议地址（Internet Protocol Address），俗称IP。
        IP地址用来给一个网络中的计算机设备做唯一的编号。相当于身份证号

        IPV4:4个字节， 32位组成。 192.168.67.87
            局域网，
            城域网，
            广域网（公网）

            局域网：公司内部用。
            公网：可以在任何地方访问。

        IPv6：可以实现为所有设备分配IP  128位

        ipconfig：查看本机IP
        ping 检查本机与某个IP指定的机器是否联通，或者说是检测对方是否在线。
        ping 空格 IP地址
        ping 220.181.57.216
        ping www.baidu.com

        注意：特殊的IP地址：本机IP地址（不受环境的影响，任何时候都存在这两个ip,可以直接找本机）
            127.0.0.1 == localhost
    3.端口：
        端口号就可以唯一标识设备中的进程(应用程序)
        端口号：
            用两个字节表示的整数，它的取值范围是0~65535
        0~1023之间的端口号用于一些知名的网络服务和应用。
        普通的应用程序需要使用1024以上的端口号。
        如果端口号被另一个服务或应用所占用，会导致当前程序启动失败，报出端口被占用异常！

        利用‘协议’+‘IP地址’+‘端口号’ 三元组合。
        就可以标识网络中的进程了，那么进程间的通信就可以利用这个标识与其他进程进行交互。
 */
public class NetDemo02 {
    public static void main(String[] args) {

    }
}
