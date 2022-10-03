package jdbc0328;

import java.io.IOException;
import java.util.Properties;

public class TestProperties2 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //读取喝当前同包的properties文件
        properties.load(TestProperties2.class.getResourceAsStream("p2.properties"));
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("age"));
        System.out.println(properties.getProperty("address"));
    }
}
