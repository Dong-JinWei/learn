<center>姓名：<u> 董金伟 </u>&nbsp;&nbsp;&nbsp;&nbsp;日期：<u>2022-06-15</u></center>

# SAX 解析

sax 解析是一行一行解析，只能对其进行查询操做，不能对其进行增删改

解析步骤：

1. 创建解析对象

```java
public class TestSax {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        // 创建解析器工厂对象
        SAXParserFactory factory = SAXParserFactory. newInstance();
        // 通过工厂创建解析器对象
        SAXParser parser = factory.newSAXParser();
    }
}
```

2. 创建一个处理类继承 DefaultHandler

```java
public class MyHandler extends DefaultHandler {

}
```

3. 将 xml 文件交给处理类来处理

```java
public class TestSax {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // 创建解析器工厂对象
        SAXParserFactory factory = SAXParserFactory. newInstance();
        // 通过工厂创建解析器对象
        SAXParser parser = factory.newSAXParser();

        // 把xml文件交给处理类来处理
        MyHandler myHandler = new MyHandler();
        parser.parse(TestSax.class.getClassLoader().getResourceAsStream("students.xml"), myHandler);
    }
}
```

获取并封装对象

```java
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
```

## 命名空间（name space）

命名空间主要解决命名冲突问题

1. 给标签前添加 单词：`<zz:table>`
2. 保证命名空间时唯一的，一般命名空间和域名（url）绑定在一起

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<tables xmlns:zz="http://java.sun.com/xml/ns/persistence/orm"
        xmlns:bg="http://java.sun.com/xml/ns/persistence">
    <zz:table>
        <name>桌子</name>
        <price>888</price>
    </zz:table>

    <bg:table>
        <tr>第一行</tr>
        <tr>第二行</tr>
    </bg:table>
</tables>
```
