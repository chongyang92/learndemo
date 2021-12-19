package com.lchy._05Dom4j解析案例;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
    目标：Dom4j解析XML文件：Contacts.xml成为一个Java的对象（集合对象）

    Contacts.xml 解析成===> List<Contact>

    分析：
        1.定义个联系人类，封装联系人书架
        2.解析成List集合。
 */
public class Dom4JDemo {
    public static void main(String[] args) throws Exception{
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read(new File("Day13Demo/src/Contacts.xml"));

        Element rootElement = document.getRootElement();

        //4.获取根元素下的全部子元素
        List<Element> elements = rootElement.elements();

        //5.遍历子元素，封装成List集合对象
        List<Contact> contactList = new ArrayList<>();
        if (elements != null && !elements.isEmpty()) {
            for (Element element : elements) {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(element.attributeValue("id")));
                contact.setVip(Boolean.parseBoolean(element.attributeValue("vip")));
                contact.setName(element.elementText("name"));
                contact.setSex(element.elementText("gender").charAt(0));
                contact.setEmail(element.elementText("email"));
                contactList.add(contact);
            }
        }
        System.out.println(contactList);
        /*for (Contact contact : contactList) {
            System.out.println(contact);
        }*/
    }
}
