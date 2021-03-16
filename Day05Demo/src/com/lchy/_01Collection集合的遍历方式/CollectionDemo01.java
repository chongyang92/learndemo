package com.lchy._01Collection集合的遍历方式;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
    目标：Collection集合的遍历方式。

    什么是遍历？为什么开发中要遍历？
        遍历就是一个一个的把容器中的元素访问一遍。
        开发中经常要统计元素的总和，找最值，找出某个数据然后干掉等等业务都需要遍历。

    Collection集合的遍历方式是全部集合都可以直接使用的，所以我们学习它
    Collection集合的遍历方式有三种：
        (1)迭代器。
        (2)foreach(增强for循环)
        (3)JDK1.8开始后的新技术Lambda表达式。

    a.迭代器遍历集合。
        --方法：
            public abstract Iterator<E> iterator();获取集合对饮的迭代器，用来遍历集合中的元素。
            E hasNext();获取下一个元素值！
            boolean hasNext():判断是否有下一个元素，有返回true，反之false;
        --流程：
            1.先获取当前结合的迭代器
                Iterator<String> it = lists.iterator();
            2.定义一个while循环，问一次取一次。
                通过it.hasNext()询问是否有下一个元素，有就通过
                it.next()取出下一个元素。
 */
public class CollectionDemo01 {
    public static void main(String[] args) {
        Collection<String> lists = new ArrayList<>();
        lists.add("赵敏");
        lists.add("小昭");
        lists.add("殷素素");
        lists.add("周芷若");
        System.out.println(lists);
        //lists = [赵敏, 小昭, 殷素素, 周芷若]
        //it

        System.out.println("---------------------");
        //1.迭代器遍历
        //得到集合的迭代器对象。
        Iterator<String> it = lists.iterator();//和集合的泛型相同
        /*System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());*/
        while (it.hasNext()){
            //System.out.println(it.next());//不能检查一次取两次
            System.out.println(it.next());
        }

        System.out.println("-----------普通for循环-------");
        for (int i = 0; i < lists.size(); i++) {
            //lists.
        }
        System.out.println("-----------普通for循环不能遍历Collection，没有索引-------");
    }
}
