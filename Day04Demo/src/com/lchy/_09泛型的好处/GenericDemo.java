package com.lchy._09泛型的好处;

import java.util.ArrayList;

/**
    目标：泛型的好处
    泛型在编译阶段约束了操作的数据类型，从而不会出现类型转换异常
    体现了Java的严谨性和规范性，数据类型，经常需要进行统一。
 */
public class GenericDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("赵敏");
        list.add("张无忌");
        list.add(false);
        list.add(99.9);

        //元素类型不确定，只能用对象接，但是这样不能很好的统一操作list列表
        for (int i = 0; i < list.size(); i++) {
            Object object = list.get(i);
            System.out.println(object);
            String s = (String)object;//ClassCastException，无法转换Boolean类型为String
            System.out.println(s);
        }

        ArrayList<String> listStr = new ArrayList<>();
        listStr.add("赵敏");
        listStr.add("张无忌");
        /*listStr.add(false);//编译阶段检查，这里直接报错，统一了类型，减少出错
        listStr.add(99.9);*/

        for (int i = 0; i < listStr.size(); i++) {
            String s = listStr.get(i);
            System.out.println(s);
        }
    }
}
