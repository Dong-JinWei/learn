package com.dowei.librarysys.test;

import com.dowei.librarysys.utils.JDBCUtils;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestJDBCUtils {
    @Test
    public void TestJDBCUtils() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn.getCatalog());
    }
}
