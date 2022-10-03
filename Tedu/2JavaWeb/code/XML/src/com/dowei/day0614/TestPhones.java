package com.dowei.day0614;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class TestPhones {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(TestPhones.class.getResource("phones.xml"));
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            System.out.println("id:" + element.attributeValue("id"));
            List<Element> els = element.elements();
            for (Element e : els) {
                System.out.println(e.getName() + "=" + e.getText());
            }
            System.out.println("==========================================");
        }
    }
}
