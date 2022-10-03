package JDBC0325;


import java.sql.*;

public class JDBCTest1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //准备数据库连接的数据
        String username = "root";
        String password = "123456";
        //指定url（服务器地址）
        /*
        jdbc:mysql  表示协议
        localhost  表示本机，还是以使用服务器ip
        3306  端口号
        bigdata 表示数据库名
         */
        String url = "jdbc:mysql://localhost:3306/mydb0322?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";
        //连接数据库服务器，获取连接对象
        //使用的Connection是java.sql包下的，不是com.mysql包下的
        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println(conn.getCatalog());
        //准备sql语句，字符串必须使用双引号，其中的内容使用单引号，每一句末尾不加分号
        String sql = "select * from t1";
        //准备“车”对象
        Statement stmt = conn.createStatement();
        //发车
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            int tid = rs.getInt("tid");
            String tname = rs.getString("tname");
            String temail = rs.getString("temail");
            System.out.printf("%d : %s : %s\n", tid, tname, temail);
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
