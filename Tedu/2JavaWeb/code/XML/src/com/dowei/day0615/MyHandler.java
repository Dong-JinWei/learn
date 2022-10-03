package com.dowei.day0615;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {
    private String qName;
    private List<Students> students;
    private Students student;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始解析文档********");
        // 开始解析文档时，初始化集合
        students = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println("开始解析" + qName + "标签");
        this.qName = qName;
        if("student".equals(qName)){
            String id = attributes.getValue("id");
            student = new Students();
            student.setId(Integer.parseInt(id));
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println("解析结束" + qName + "标签");
        if("student".equals(qName)){
            students.add(student);
        }
    }

    // 获取数据
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch,start, length).trim();
        if(!"".equals(str)){
//            System.out.println(qName + "="+str);
            if("name".equals(qName)){
                student.setName(str);
            }
            if("age".equals(qName)){
                student.setAge(Integer.parseInt(str));
            }
        }
    }

    @Override
    public void endDocument() throws SAXException {
        // 文档解析完毕时，数据已经完全封装完毕
        System.out.println(students);
        System.out.println("文档解析结束********");
    }
}
