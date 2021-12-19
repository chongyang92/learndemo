package com.lchy.principles._03依赖倒转原则._02after;

public class XiJieHardDisk implements HardDisk{
    //存储数据的方法
    public void save(String data){
        System.out.println("使用希捷硬盘存储数据为："+data);
    }

    //获取数据的方法
    public String get(){
        System.out.println("使用希捷硬盘取数据");
        return "数据";
    }
}
