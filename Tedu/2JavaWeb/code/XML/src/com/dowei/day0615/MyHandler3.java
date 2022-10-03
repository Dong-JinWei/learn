package com.dowei.day0615;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler3 extends DefaultHandler {
    private String qName;
    private List<Phone> phoneList;
    private Phone phone;

    @Override
    public void startDocument() throws SAXException {
        phoneList = new ArrayList<>();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(phoneList);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.qName = qName;
        if ("phone".equals(qName)){
            String id = attributes.getValue("id");
            phone = new Phone();
            phone.setId(Integer.parseInt(id));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("phone".equals(qName)){
            phoneList.add(phone);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length).trim();
        if (!"".equals(str)){
            if("name".equals(qName)){
                phone.setName(str);
            }else if("price".equals(qName)){
                phone.setPrice(Double.parseDouble(str));
            }
        }
    }
}
