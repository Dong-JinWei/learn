package jdbc0327.homework;

import java.sql.*;

public class JDBCUtils {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private JDBCUtils(){ }

    public static Connection getConnection(){
        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/mysql0327?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Statement stmt, Connection conn){
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(stmt, conn);
    }
}
