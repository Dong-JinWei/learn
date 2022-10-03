package com.dowei.day0614;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class TestDog {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(TestDog.class.getResource("dogs.xml"));
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            // 获取指定元素的属性
            System.out.println("id：" + element.attributeValue("id"));
            List<Element> els = element.elements();
            for (Element el : els) {
                // getText() 获取标签中的内容
                System.out.println(el.getName() + "=" +el.getText());
            }
        }
    }
}
