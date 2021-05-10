package com.lchy._04字符缓冲流;

import java.io.*;
import java.util.*;

/**
    目标：题目练习。

    需求：把《出师表》的文章顺序进行恢复到一个新文件中！

    分析：
        （1）创建一个字符缓冲输入流对象
        （2）创建一个字符缓冲输出流对象
        （3）按照行读，以.分隔符放到List
        （4）写入到字符缓冲输出流
 */
public class ExecDemo {
    //public static Map<String,Integer> map = new HashMap<>();

    public static List<String> characters = new ArrayList<>();
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Collections.addAll(characters,"一","二","三","四","五","六","七","八","九","十");
        try(
                BufferedReader mapBufferedReader = new BufferedReader(new FileReader("Day10Demo\\src\\map.txt"));

                BufferedReader bufferedReader = new BufferedReader(new FileReader("Day10Demo\\src\\csb.txt"));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Day10Demo\\src\\newcsb.txt"))){
            /*String mapLine;
            while ((mapLine = mapBufferedReader.readLine()) != null){
                String[] mapLineArr = mapLine.split("=");
                map.put(mapLineArr[0],Integer.valueOf(mapLineArr[1]));
            }*/

            /*Properties properties = new Properties();
            properties.load(mapBufferedReader);*/

            String line;
            while ((line = bufferedReader.readLine()) != null){
                list.add(line);
            }

            list.sort((o1, o2) ->  characters.indexOf(o1.split("\\.")[0]) - characters.indexOf(o2.split("\\.")[0]));
            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
