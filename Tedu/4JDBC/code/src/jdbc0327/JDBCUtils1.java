package jdbc0327;

import java.sql.*;

public class JDBCUtils1 {
    private JDBCUtils1() {

    }

    //定义获取连接对象
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "root";
            String password = "123456";
            String url = "jdbc:mysql://localhost:3306/mydb0322?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭两个资源的方法
    public static void close(Statement stmt, Connection conn) {
        try {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        try{
           if (rs != null){
               rs.close();
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(stmt, conn);
    }
}
