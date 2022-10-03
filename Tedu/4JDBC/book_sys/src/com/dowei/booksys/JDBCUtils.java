package com.dowei.booksys;

import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    static Properties properties = new Properties();
    static {
        try {
            //一个作用域的范围是理他最近的大括号
            //Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties"));
            String driverClassName = properties.getProperty("driverClassName");
            Class.forName(driverClassName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private JDBCUtils() {}
    //定义获取连接对象
    public static Connection getConnection() {
        try {
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭两个资源的方法
    public static void close(PreparedStatement pstmt, Connection conn) {
        try {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(pstmt, conn);
    }
}
