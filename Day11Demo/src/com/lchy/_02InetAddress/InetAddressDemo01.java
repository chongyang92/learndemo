package com.lchy._02InetAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
    目标：InetAddress类的概述
        一个该类的对象就代表一个IP地址对象。
    InetAddress类成员方法：
        static InetAddress getLocalHost()
            * 获得本地主机IP地址对象。
        static InetAddress getByName(String host)
            * 根据IP地址字符串或主机名获得对应的IP地址对象。
        String getHostName()
            * 获得主机名。
        String getHostAddress()
            * 获得IP地址字符串。
 */
public class InetAddressDemo01 {
    public static void main(String[] args) throws IOException {
        //1.获取本机地址对象。
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip.getHostName());
        System.out.println(ip.getHostAddress());

        //2.获取局域网ip对象
        InetAddress ip2 = InetAddress.getByName("baidu.com");
        System.out.println(ip2.getHostName());
        System.out.println(ip.getHostAddress());

        //3.获取公网IP对象
        InetAddress ip3 = InetAddress.getByName("14.215.177.38");
        System.out.println(ip3.getHostName());
        System.out.println(ip3.getHostAddress());

        //4.判断是否能ping通
        System.out.println(ip2.isReachable(5000));
    }
}
