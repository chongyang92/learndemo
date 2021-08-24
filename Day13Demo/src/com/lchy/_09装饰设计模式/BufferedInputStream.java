package com.lchy._09装饰设计模式;
//装饰模式
public class BufferedInputStream extends InputStream {
    //定义一个来接收
    private InputStream is;
    //包装流
    public BufferedInputStream(InputStream is){
        this.is = is;
    }
    @Override
    public void read() {
        System.out.println("开启高效缓冲读取~");
        is.read();
    }

    @Override
    public void close() {
        is.close();
    }
}
