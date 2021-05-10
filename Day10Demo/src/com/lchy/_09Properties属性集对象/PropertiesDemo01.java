package com.lchy._09Properties属性集对象;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

/**
    目标：Properties读取属性文件中的键值对信息（读取）（保存数据到属性文件）

    Properties：属性集对象。
        其实就是一个Map集合。也就是一个键值对集合。但是我们一般不会当集合使用，
            因为有HashMap。
    Properties核心作用：
        Properties代表的是一个属性文件，可以把键值对的数据存入到一个属性文件中去。
        属性文件：后缀是.properties结尾的文件，里面的内容都是key=value。

    大家在后期学的很多大型框架技术中，属性文件都是很重要的系统配置文件。
        user.properties
                admin=123456
                dilei=dilei

    需求：使用Properties对象生成一个属性文件，里面存入用户名和密码信息。

    Properties的方法：
        -- public Object setProperty(String key, String value):保存一对属性。
        -- public String getProperty(String key):使用此属性列表中指定的键搜索属性值
        -- public Set<String> stringPropertyNames():所有键的名称的集合
        -- public void store(OutputStream out, String comments):保存数据到属性文件中去
        -- public synchronized void load(InputStream inStream):加载属性文件的数据到属性集合中
        -- public synchronized void load(Reader fr):加载属性文件的数据到属性集对象中去
    小结：
        属性集对象Properties实际上是一个Map集合，可以实现把键值对数据保存到
        属性文件中去！
 */
public class PropertiesDemo01 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("admin","123456");
        properties.setProperty("dilei","boom");
        System.out.println(properties);
        try(
                PrintStream printStream = new PrintStream("Day10Demo\\src\\pro.txt");){
            /**
             * 参数一：把属性集对象的数据存入到属性文件中去（重点）
             * 参数二：保存心得，就是对象保存的数据进行说明
             */
            properties.store(printStream,"123");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
