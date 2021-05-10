package com.lchy._08即时通信;

import java.io.*;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

/**
    拓展：（了解）

    引入：
        我们之前引入的线程解决一个服务端可以接收多个客户端消息
        客户端与服务端的线程模型是：N-N的关系。一个客户端要一个线程。
        这种模型是不行的，并发越高，系统瘫痪的越快！

    解决：
        我们可以在服务端引入线程池，使用线程池来处理与客户端的消息通信！
        线程池不会引起出现过多的线程而导致系统死机！

    这种方案的优劣势：
        优势：不会引起系统的死机，可以控制并发线程的数量
        劣势：同时可以并发的线程将收到限制
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1.获取名称列表
        Properties properties = new Properties();
        properties.load(new FileReader("Day11Demo/src/namelist.txt"));
        Scanner userNameScanner = new Scanner(System.in);
        System.out.println("please input your name");
        String userName = userNameScanner.nextLine();
        System.out.println("你的好友"+properties.getProperty(userName));
        Scanner friendNameScanner = new Scanner(System.in);
        System.out.println("发消息给：");
        String friendName = friendNameScanner.nextLine();

        //1.连接服务端IP和端口
        Socket socket = new Socket("127.0.0.1",9999);
        //2.获取输出流
        OutputStream outputStream = socket.getOutputStream();
        //3.获取输入流
        InputStream inputStream = socket.getInputStream();
        //3.对输出流进行包装,使能直接写入各种类型的数据
        PrintStream printStream = new PrintStream(outputStream);
        new Thread(){
            @Override
            public void run() {
                while (true){

                    try{
                        System.out.println("yyyyyyyyyyyyyyy");
                        sleep(1000);
                       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        String line = null;
                        while ((line = bufferedReader.readLine()) != null){
                            System.out.println("收到消息:"+line);
                        }*/

                    }catch ( InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }
        };


        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入消息：");
            //printStream.println(userName+","+s+","+scanner.nextLine());
            String msg = scanner.nextLine();
            printStream.println(userName+","+friendName+","+msg);
            printStream.flush();

        }
    }
}
