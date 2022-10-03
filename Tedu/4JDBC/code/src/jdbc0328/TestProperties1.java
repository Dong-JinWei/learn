package jdbc0328;

import java.io.IOException;
import java.util.Properties;

public class TestProperties1 {
    public static void main(String[] args) throws IOException {
        //创建Properties对象
        Properties properties = new Properties();
        //加载src中的配置文件
        properties.load(TestProperties1.class.getClassLoader().getResourceAsStream("p1.properties"));
        //通过getProperty方法来读取键对应的值
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("age"));
        System.out.println(properties.getProperty("address"));
    }
}
