package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLTest {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        File file = new File("a.xml");
        Document document  = documentBuilder.parse(file);
        NodeList city = document.getElementsByTagName("city");
        for(int i = 0; i < city.getLength(); i++){
            Node item = city.item(i);
            System.out.println(item.getTextContent());
        }

    }
}
