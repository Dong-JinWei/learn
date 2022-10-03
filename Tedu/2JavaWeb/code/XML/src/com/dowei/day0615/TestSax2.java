package com.dowei.day0615;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class TestSax2 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler2 myHandler2 = new MyHandler2();
        parser.parse(TestSax2.class.getClassLoader().getResourceAsStream("workers.xml"), myHandler2);
    }
}
