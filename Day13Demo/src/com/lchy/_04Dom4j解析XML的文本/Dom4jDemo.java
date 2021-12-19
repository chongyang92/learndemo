package com.lchy._04Dom4j解析XML的文本;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
    目标：Dom4j解析XML的文本；

    Element：
        String elementText(String name); 可以直接获取当前元素的子元素的文本内容
        String elementTextTrm(String name); 去前后空格，直接获取当前元素的子元素的文本内容
        String getText();直接获取当前元素的文本内容。
        String getTextTrim();去前后空格，直接获取当前元素的文本内容。
 */
public class Dom4jDemo {
    public static void main(String[] args) throws Exception{
        //1.创建一个dom4j的解析器对象：代表整个dom4j框架
        SAXReader saxReader = new SAXReader();
        //2.通过解析器对象去加载xml文件数据，成为一个Document文档树对象。
        Document document = saxReader.read(new File("Day13Demo/src/books.xml"));
        //3.获取根元素对象
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());

        String rootattributeValue = rootElement.attributeValue("id");
        System.out.println(rootattributeValue);

        //获取第一个子元素
        Element book = rootElement.element("book");
        String id = book.attributeValue("id");
        System.out.println(id);
        Element name = book.element("name");
        System.out.println(name.getName());
        String nameValue = book.elementText("name");
        String nameValue1 = name.getText();
        System.out.println(nameValue);
        System.out.println(nameValue1);
    }
}
