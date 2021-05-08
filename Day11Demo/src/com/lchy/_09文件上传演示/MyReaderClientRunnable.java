package com.lchy._09文件上传演示;

import java.io.*;
import java.net.Socket;

public class MyReaderClientRunnable implements Runnable {
    private Socket socket;
    public MyReaderClientRunnable(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try(
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = new FileOutputStream("F:/file/image/a.jpg")){
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            System.out.println("图片接收完毕！");
            OutputStream outputStreamResult = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStreamResult);
            printStream.println("收到了图片");
            printStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
