package com.lchy._06XPath检索XML中的信息;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
    目标：XPath检索XML中的信息

    引入：
        Dom4j可以用于解析整个XML的数据。
        但是如果要检索XML中的某些信息，建议使用XPath。
    XPath使用步骤：
        1.导入dom4j框架。（XPath依赖于Dom4j技术，必须先导入dom4j）
        2.导入XPath独有的框架包。jaxen-1.1.2.jar
    XPath常用API：
        List<Node> selectNodes(String var1):检索出一批节点集合。
        Node selectSingleNode(String var1):检索出一个节点返回。
    XPath提供的四种检索数据的写法：
        1.绝对路径。
        2.相对路径。
        3.全文检索。
        4.属性查找。
    小结：
    1.绝对路径： /根元素/子元素/子元素。
    2.相对路径： ./子元素/子元素（。代表了当前元素）
    3.全文搜索：
            //元素  在全文找这个元素
            //元素1/元素2  在全文找元素1下面的一级元素2
            //元素1//元素2  在全文找元素1下面的全部元素2
    4.属性查找。
            //@属性名称  在全文检索属性对象。
            //元素[@属性名称]  在全文检索包含该属性的元素对象。
            //元素[@属性名称=值]  在全文检索包含该属性的元素且属性值为该值的元素对象。
 */
public class XPathDemo {

    // 1.绝对路径： /根元素/子元素/子元素。
    @Test
    public void path01() throws Exception{
        SAXReader saxReader = new SAXReader();

        InputStream resourceAsStream = XPathDemo.class.getResourceAsStream("/Contact.xml");
        //Document document = saxReader.read("Day13Demo/src/Contact.xml");
        Document document = saxReader.read(resourceAsStream);
        Element rootElement = document.getRootElement();

        //3.使用绝对路径定位全部的name名称
        List<Node> nodes = document.selectNodes("/contactList/contact/name");
        for (Node node : nodes) {
            System.out.println(node.getText());
        }
    }

    // 2.相对路径： ./子元素/子元素(代表当前元素)。
    @Test
    public void path02() throws Exception{
        SAXReader saxReader = new SAXReader();

        InputStream resourceAsStream = XPathDemo.class.getResourceAsStream("/Contact.xml");
        //Document document = saxReader.read("Day13Demo/src/Contact.xml");
        Document document = saxReader.read(resourceAsStream);
        Element rootElement = document.getRootElement();

        //3.使用绝对路径定位全部的name名称
        List<Node> nodes = rootElement.selectNodes("./contact/name");
        for (Node node : nodes) {
            System.out.println(node.getText());
        }
    }

    //3.全文搜索：
    //            //元素  在全文找这个元素
    //            //元素1/元素2  在全文找元素1下面的一级元素2
    //            //元素1//元素2  在全文找元素1下面的全部元素2
    @Test
    public void path03() throws Exception{
        SAXReader saxReader = new SAXReader();

        InputStream resourceAsStream = XPathDemo.class.getResourceAsStream("/Contact.xml");
        Document document = saxReader.read(resourceAsStream);

        //3. //name是指在整个xml文件中检索name节点！
        List<Node> nodes = document.selectNodes("//name");
        for (Node node : nodes) {
            System.out.println(node.getText());
        }

        System.out.println("------------");
        List<Node> nodes1 = document.selectNodes("//contact/name");
        for (Node node : nodes1) {
            System.out.println(node.getText());
        }

        System.out.println("------------");
        List<Node> nodes2 = document.selectNodes("//contact//name");
        for (Node node : nodes2) {
            System.out.println(node.getText());
        }

    }

    //4.属性查找。
    //      //@属性名称  在全文检索属性对象。
    //      //元素[@属性名称]  在全文检索包含该属性的元素对象。
    //      //元素[@属性名称=值]  在全文检索包含该属性的元素且属性值为该值的元素对象。
    @Test
    public void path04() throws Exception{
        SAXReader saxReader = new SAXReader();

        InputStream resourceAsStream = XPathDemo.class.getResourceAsStream("/Contact.xml");
        Document document = saxReader.read(resourceAsStream);

        List<Node> attributs = document.selectNodes("//@id");
        for (Node attribut : attributs) {
            System.out.println(attribut.getName()+"==>"+attribut.getText());
        }
        System.out.println("=================");
        // 4. //元素[@属性名称]  在全文检索包含该属性的元素对象。
        List<Node> nodeEles = document.selectNodes("//contact[@id]");
        for (Node nodeEle : nodeEles) {
            System.out.println(nodeEle.getName());
        }
        System.out.println("=================");
        //5. //元素[@属性名称=值]  在全文检索包含该属性的元素且属性值为该值的元素对象。
        Node nodeEles1 = document.selectSingleNode("//contact[@id=2]");
        Element element = (Element) nodeEles;
        System.out.println(element.elementText("name"));

    }

}
