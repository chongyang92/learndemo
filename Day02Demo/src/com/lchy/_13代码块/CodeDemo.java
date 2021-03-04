package com.lchy._13代码块;

import java.util.ArrayList;
import java.util.List;

/**
    目标：静态代码块研究(重点)

    类有5大成份：属性，方法，构造器，代码块，内部类

    代码块按照有无static修饰可以分为：静态代码块，实例代码块

    （1）静态代码块：
            格式： static{

            }
            --必须用static修饰，属于类，会与类一起加载，而且自动触发执行一次。
            --静态代码块可以用于在执行类的方法之前进行静态资源的初始化操作。
    小结：
        静态代码块属于类的成份，应该用static修饰，属于类，会与类一起优先加载，而且自动触发一次。
        静态代码块可以用于在执行类的方法之前进行静态资源的初始化操作。(拓展)
    (2)实例代码块（基本没用）
            格式： {}
            --必须无static修饰，属于类的每个对象，会与类的每个对象一起加载，
                每次创建对象的适合，实例代码块就会触发执行一次。
            --实例代码块可以用于初始化实例资源（拓展）
            --实例代码块实际上是提取到每个构造器中去执行的(拓展)
 */
public class CodeDemo {
    public static List<String> list = new ArrayList<>();
    //（1）静态代码块
    static {
        System.out.println("静态代码块执行一次");
        list.add("红桃A");
        list.add("方片5");
    }
    //list.add("红桃A");//这里编译报错，不属于类五大成份
    private String name;
    //实例代码块
    {
        name = "张三";//每个创建的对象的name属性，都是张三
        System.out.println("实例代码块执行");
        list.add("红桃6");//创建对象的时候
    }

    //实例代码块实际上是提取到每个构造器中去执行的(拓展)
    public CodeDemo(int age){
        //反编译会发现，实例代码块会放到这里被执行
        /*name = "张三";
        System.out.println("实例代码块执行");
        list.add("红桃6");*/
    }
    public CodeDemo(){
        //反编译会发现，实例代码块会放到这里被执行
        /*name = "张三";
        System.out.println("实例代码块执行");
        list.add("红桃6");*/
    }

    public static void main(String[] args) {
        //静态代码块与类一起加载一次
        System.out.println("main方法执行一次");
        System.out.println(list);
        System.out.println("----------------------");
        //实例代码块，会在创建对象后在构造器中执行,不管是有参还是无参构造器，都会有一份实例代码块的拷贝
        CodeDemo codeDemo = new CodeDemo(30);
        System.out.println(list);
    }
}
