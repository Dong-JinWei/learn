package jdbc0328;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest2 {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            //开启事务
            //mysql默认是一条sql语句是一个事务， 是自动提交的，如果要手动提交，需要改成false
            conn.setAutoCommit(false);
            //从张三账户扣除1000元
            String sql = "update zhangsan set zmoney = zmoney - ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1000);
            pstmt.executeUpdate();
            System.out.println(3 / 0);
            //给李四账户添加1000元
            sql = "update lisi set lmoney = lmoney + ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1000);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            //回滚数据
            conn.rollback();
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }


    }
}
