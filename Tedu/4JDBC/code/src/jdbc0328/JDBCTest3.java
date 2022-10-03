package jdbc0328;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest3 {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtils2.getConnection();
        System.out.println(conn.getCatalog());
        String sql = "select * from zhangsan";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            System.out.println(rs.getInt("zmoney"));
        }
        JDBCUtils.close(pstmt, conn);

    }
}