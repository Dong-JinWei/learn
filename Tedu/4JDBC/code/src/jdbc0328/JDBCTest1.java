package jdbc0328;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest1 {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        //从张三账户扣除1000元
        String sql = "update zhangsan set zmoney = zmoney - ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 1000);
        pstmt.executeUpdate();
        //给李四账户添加1000元
        sql = "update lisi set lmoney = lmoney + ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 1000);
        pstmt.executeUpdate();
        JDBCUtils.close(pstmt, conn);

    }
}
