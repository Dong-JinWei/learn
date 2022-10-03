package jdbc0327;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC3 {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtils2.getConnection();
        String sql = "select * from user where username = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "djw");
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("password"));
        }
        JDBCUtils2.close(rs, pstmt, conn);



    }
}
