package com.dowei.day0614;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class TestStudents {
    public static void main(String[] args) throws DocumentException {
        // 1. 获取解析器对象
        SAXReader reader = new SAXReader();
        // 2. 加载src中的XML文件，返回一个Document对象
//        Document document = reader.read(TestStudents.class.getClassLoader().getResourceAsStream("students.xml"));
        // 2. 加载同包中的XML文件
        Document document = reader.read(TestStudents.class.getResourceAsStream("dogs.xml"));

        // 3. 获取根元素
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());

        // 4. 获取根元素的直接子元素
        List<Element> elements = rootElement.elements();

        for (Element element : elements){
            // 获取指定元素的属性
            System.out.println("id:"+element.attributeValue("id"));
            List<Element> els = element.elements();
            for (Element e : els) {
                // 获取标签的内容
                System.out.println(e.getName() +"="+ e.getText());
            }
        }
    }
}
