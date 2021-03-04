package com.lchy._05多态接口的综合案例;

/**
    拓展：面向对象思想设计一个电脑对象，可以接入2个USB设备
        （鼠标、键盘：实现接入，调用独有功能，拔出）

    分析：
        （1）提供2个USB设备（USB设备必须满足：接入和拔出功能）
        （2）定义一个USB接口（申明USB设备的规范必须是实现接入和拔出功能）
        （3）开始定义2个真实的实现类代表鼠标和键盘
        （4）定义一个电脑类。


 */
public class Demo {
    public static void main(String[] args) {
        //1.买一个电脑
        Computer computer = new Computer();
        //买一个鼠标
        USB xiaomi = new Mouse("小米");
        computer.install(xiaomi);

        //买一个键盘
        KeyBoard keyBoard = new KeyBoard("技嘉");
        computer.install(keyBoard);
    }
}

class Computer{
    //提供一个安装USB设备的入口
    public void install(USB usb){
        usb.connect();//规范方法
        if(usb instanceof Mouse){
            Mouse mouse = (Mouse)usb;
            mouse.dbclic();
        }else if(usb instanceof KeyBoard){
            KeyBoard keyBoard = (KeyBoard)usb;
            keyBoard.keyDown();
        }
        usb.unConnect();//规范方法
    }
}

//定义2个USB设备
class Mouse implements USB{

    private String name;

    public Mouse(String name){
        this.name = name;
    }

    //独有功能
    public void dbclic(){
        System.out.println(name + "双击了666");
    }

    @Override
    public void connect() {
        System.out.println(name + "成功接入了设备");
    }

    @Override
    public void unConnect() {
        System.out.println(name + "成功拔出了设备");
    }
}

class KeyBoard implements USB{
    private String name;

    public KeyBoard(String name){
        this.name = name;
    }

    //键盘
    public void keyDown(){
        System.out.println(name + "点亮小红心");
    }

    @Override
    public void connect() {
        System.out.println(name + "成功接入了设备");
    }

    @Override
    public void unConnect() {
        System.out.println(name + "成功拔出了设备");
    }
}

interface USB{
    void connect();//接入
    void unConnect();//拔出
}
