package com.dowei.day0615;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class TestSax3 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();


        MyHandler3 myHandler3 = new MyHandler3();
        parser.parse(TestSax3.class.getResourceAsStream("phones.xml"), myHandler3);

    }
}
