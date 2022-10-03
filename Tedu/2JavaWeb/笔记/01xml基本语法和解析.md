<center>姓名：<u> 董金伟 </u>&nbsp;&nbsp;&nbsp;&nbsp;日期：<u>2022-06-14</u></center>

# XML

常见的配置文件

- properties 文件，书写格式：键=值，#注释内容

XML 文件：Extensible Markup Language（可扩展的标记语言）

XML 的作用：

- 传输文件
- 配置文件（主要作用）

## XML 语法格式

```XML
<?xml version="1.0" encoding="utf-8" ?>
<!--  version表示版本，目前都是1.0版本-->
<!--  encoding表示编码，一般都使用utf-8-->

<!-- xml语法要求严格：xml要求一个xml文件只能有一个根元素 -->
<!-- xml区分大小写 -->
<!--  双标签必须有闭合标签（结束标签）-->
<Books>
    <book id="3">
        <name>java大全</name>
        <price>25</price>
<!--          如果双标签重没有内容，可以转换成单标签-->
        <author/>
    </book>
</Books>
```

## XML 的约束

xml 约束有两种：

1. dtd 约束，根元素中以 dtd 结尾的就是 dtd 约束
2. schema 约束，根元素重以 xsd 结尾的就是 schema 约束

约束的作用就是规定标签的使用规则

## 解析 XML 数据

有两种：

1. DOM 解析，一次性把整个 DOM 树加载到内存中，就可以对整个 DOM 树进行增删改查；缺点，如果 DOM 树比较大，可能会造成内存溢出
2. SAX 解析：一行一行解析，只能进行查询，不能进行增删改，不会造成内存溢出

### 使用 DOM 解析步骤

1. 导入 jar 包，把 jar 包拷贝到 lib 文件夹下
2. 将 jar 包添加到库
3. 在项目 scr 中创建一个 student.xml 文件
4. 解析 XML 文件

```java
package com.dowei;

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

```
