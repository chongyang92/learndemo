package com.lchy._08即时通信;

import java.io.*;
import java.net.Socket;
import java.util.Map;

/**
    目标：将每个连接做成线程任务，在此处理
 */
public class ReaderClientRunnable implements Runnable {
    private Map<String,Socket> map;
    private Socket socket;
    public ReaderClientRunnable(Socket socket,Map map){
        this.socket = socket;
        this.map = map;
    }
    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            String sendto = null;
            while ((line = bufferedReader.readLine()) != null){
                String[] l = line.split(",");
                sendto = l[1];
                System.out.println(line);
                if(!map.containsKey(sendto)){
                    map.put(sendto,socket);
                }
                Socket socketSend = map.get(sendto);
                OutputStream outputStream = socketSend.getOutputStream();
                PrintStream printStream = new PrintStream(outputStream);
                printStream.println(l[2]);
                printStream.flush();
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
