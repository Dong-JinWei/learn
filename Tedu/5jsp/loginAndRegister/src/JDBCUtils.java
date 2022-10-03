import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    static Properties properties = new Properties();
    static {
        try {
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
            String driverClassName = properties.getProperty("driverClassName");
            Class.forName(driverClassName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private JDBCUtils(){}

    public static Connection getConnection(){
        try {
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(PreparedStatement pstmt, Connection conn){
        try {
            if (pstmt != null){
                pstmt.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        close(pstmt, conn);
    }

}