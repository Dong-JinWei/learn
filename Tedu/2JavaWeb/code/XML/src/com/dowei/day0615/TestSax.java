package com.dowei.day0615;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class TestSax {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // 创建解析器工厂对象
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 通过工厂创建解析器对象
        SAXParser parser = factory.newSAXParser();

        // 把xml文件交给处理类来处理
        MyHandler myHandler = new MyHandler();
        parser.parse(TestSax.class.getClassLoader().getResourceAsStream("students.xml"), myHandler);
    }
}
