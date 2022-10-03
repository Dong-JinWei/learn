package jdbc0327;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCUtilsTest3 {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();

        System.out.println(username);
        System.out.println(password);

        Connection conn = JDBCUtils2.getConnection();
        //编写sql语句，先书写一个完整的sql语句，先测试是否可以正确执行
        String sql = "SELECT * FROM USER WHERE username = '"+username +"' AND PASSWORD = '"+ password +"'";
        System.out.println(sql);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

        JDBCUtils2.close(rs, stmt, conn);


    }
}
