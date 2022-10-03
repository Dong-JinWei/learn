package cn.tedu.test;


import cn.tedu.util.JDBCUtile;
import org.testng.annotations.Test;

import java.sql.Connection;

public class JDBCUtilsTest {

    @Test
    public void testJDBU(){
        Connection connection = JDBCUtile.getConnection();
        System.out.println(connection);
    }

}
