package XML;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileReader reader = new FileReader("a.properties");
        properties.load(reader);
        Set<String> strings = properties.stringPropertyNames();
        for (String str: strings){
            String property = properties.getProperty(str);
            System.out.println(str + " " + property);
        }
        reader.close();
    }
}
