package jdbc0328.homework;

import java.sql.*;

public class Student {

    //增加数据
    public void insert(String name, String sex, String address) throws SQLException {
        //String sql = "INSERT INTO student(NAME, sex, address) VALUES('" + name + "', '" + sex + "', '" + address + "')";
        String sql = "INSERT INTO student(NAME, sex, address) VALUES(?, ?, ?)";
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, sex);
        pstmt.setString(3, address);
        int effect = pstmt.executeUpdate();
        if (effect > 0) {
            System.out.printf("插入了%d行\n", effect);
        } else {
            System.out.println("插入失败 ");
        }

        JDBCUtils.close(pstmt, conn);
    }

    //查询数据
    public void select(String name) throws SQLException {
        //String sql = "select * from student where name = '" + name + "'";
        String sql = "select * from student where name = ?";
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("学号：" + rs.getInt("id"));
            System.out.println("姓名：" + rs.getString("name"));
            System.out.println("性别：" + rs.getString("sex"));
            System.out.println("家庭住址：" + rs.getString("address"));
        } else {
            System.out.println("查无此人~~");
        }

        JDBCUtils.close(rs, pstmt, conn);
    }

    //删除数据
    public void delete(String name) throws SQLException {
        //String sql = "DELETE FROM student WHERE NAME = '" + name + "'";
        String sql = "DELETE FROM student WHERE NAME = ?";
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        int i = pstmt.executeUpdate();

        if (i > 0) {
            System.out.printf("删除了%d行\n", i);
        } else {
            System.out.println("删除失败 ");
        }

        JDBCUtils.close(pstmt, conn);
    }

    //修改数据
    public void update(String newAddress, String name) throws SQLException {
        //String sql = "UPDATE student SET address = '" + newAddress + "' WHERE NAME = '" + name + "'";
        String sql = "UPDATE student SET address = ? WHERE NAME = ?";
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newAddress);
        pstmt.setString(2, name);
        int i = pstmt.executeUpdate();

        if (i > 0) {
            System.out.printf("修改了%d行\n", i);
        } else {
            System.out.println("修改失败 ");
        }
    }
}
