package jdbc0328;

import java.sql.*;

public class JDBCUtils {
    private JDBCUtils() {

    }

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
          }

    //定义获取连接对象
    public static Connection getConnection() {
        try {
            String username = "root";
            String password = "123456";
            String url = "jdbc:mysql://localhost:3306/mydb0321?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";

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
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
        try{
           if (rs != null){
               rs.close();
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(pstmt, conn);
    }
}
