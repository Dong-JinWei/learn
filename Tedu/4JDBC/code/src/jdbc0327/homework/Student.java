package jdbc0327.homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {

    //增加数据
    public void insert(String name, String sex, String address) throws SQLException {
        String sql = "INSERT INTO student(NAME, sex, address) VALUES('" + name + "', '" + sex + "', '" + address + "')";
        Connection conn = JDBCUtils.getConnection();
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate(sql);
        if (i > 0) {
            System.out.printf("插入了%d行\n", i);
        } else {
            System.out.println("插入失败 ");
        }

        JDBCUtils.close(stmt, conn);
    }

    //查询数据
    public void select(String name) throws SQLException {
        String sql = "select * from student where name = '" + name + "'";
        Connection conn = JDBCUtils.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            System.out.println("学号：" + rs.getInt("id"));
            System.out.println("姓名：" + rs.getString("name"));
            System.out.println("性别：" + rs.getString("sex"));
            System.out.println("家庭住址：" + rs.getString("address"));
        } else {
            System.out.println("查无此人~~");
        }

        JDBCUtils.close(rs, stmt, conn);
    }

    //删除数据
    public void delete(String name) throws SQLException {
        String sql = "DELETE FROM student WHERE NAME = '" + name + "'";
        Connection conn = JDBCUtils.getConnection();
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate(sql);

        if (i > 0) {
            System.out.printf("删除了%d行\n", i);
        } else {
            System.out.println("删除失败 ");
        }

        JDBCUtils.close(stmt, conn);
    }

    //修改数据
    public void update(String newAddress, String name) throws SQLException {
        String sql = "UPDATE student SET address = '" + newAddress + "' WHERE NAME = '" + name + "'";
        Connection conn = JDBCUtils.getConnection();
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate(sql);

        if (i > 0) {
            System.out.printf("修改了%d行\n", i);
        } else {
            System.out.println("修改失败 ");
        }
    }
}
