package com.dowei.day0615;
import com.dowei.day0615.Workers;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler2 extends DefaultHandler {
    private String qName;
    private List<Workers> workerList;
    private Workers worker;

    @Override
    public void startDocument() throws SAXException {
        workerList = new ArrayList<>();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(workerList);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.qName = qName;
        if ("worder".equals(qName)){
            String id = attributes.getValue("id");
            worker = new Workers();
            worker.setId(Integer.parseInt(id));

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("worder".equals(qName)){
            workerList.add(worker);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length).trim();
        if(!"".equals(str)){
            str = str.trim();
            if("name".equals(qName)){
                worker.setName(str);
            }
            else if("age".equals(qName)){
                worker.setAge(Integer.parseInt(str));
            }else if("wage".equals(qName)){
                worker.setWage(Double.parseDouble(str));
            }
        }
    }
}
