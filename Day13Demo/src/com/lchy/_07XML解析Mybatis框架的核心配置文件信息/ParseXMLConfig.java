package com.lchy._07XML解析Mybatis框架的核心配置文件信息;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class ParseXMLConfig {
    @Test
    public void parseXML() throws Exception{
        //1.创建一个解析器对象
        SAXReader saxReader = new SAXReader();

        //2.加载类路径下的XML文件成为一个Document文档文件
        Document document = saxReader.read(ParseXMLConfig.class.getResourceAsStream("/sqlMapConfig.xml"));

        //3.获得根元素对象
        Element rootElement = document.getRootElement();

        //4.获取子元素environments
        Element environments = rootElement.element("environments");

        //5.获取子元素environment
        Element environment = environments.element("environment");

        //6.获取子元素dataSource
        Element dataSource = environment.element("dataSource");

        //7.获取 dataSource下的全部子元素
        List<Element> elements = dataSource.elements();
        for (Element element : elements) {
            //
            System.out.println(element.getName()+"=>"+element.getText());
            System.out.println(element.getName()+"=>"+element.elementText("name"));
            System.out.println(element.getName()+"=>"+element.attributeValue("name"));
            System.out.println(element.getName()+"=>"+element.attributeValue("value"));
        }

    }
}
