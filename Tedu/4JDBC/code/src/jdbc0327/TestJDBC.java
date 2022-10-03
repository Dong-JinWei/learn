package jdbc0327;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "root";
            String password = "123456";
            String url = "jdbc:mysql://localhost:3306/mydb0322?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn.getCatalog());
            String sql = "select * from t1";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int tid = rs.getInt("tid");
                String tname = rs.getString("tname");
                String temail = rs.getString("temail");
                System.out.printf("%d : %s : %s\n", tid, tname, temail);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
