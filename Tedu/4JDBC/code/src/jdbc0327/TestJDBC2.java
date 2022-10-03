package jdbc0327;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC2 {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtils2.getConnection();

        //准备sql
        //？表示占位符，需要插入数据的地方一律使用？代替， 避免了拼接字符串
        //增加了可读性
        String sql = "insert into user values( null, ?, ?)";

        //获取PreparedStatement对象，并传入sql语句
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //给问好设置值， 同个setXXX来赋值
        //第一个参数表示第几个问好，注意从一开始
        pstmt.setString(1, "dowie");
        pstmt.setString(2, "123");

        //此时不需要传递sql
        int effect = pstmt.executeUpdate();
        System.out.printf("影响了%d行\n", effect);
        JDBCUtils2.close(pstmt, conn);
    }
}
