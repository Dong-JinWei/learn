package jdbc0327;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtilsTest2 {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtils2.getConnection();
        String sql = "select * from t1";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            int tid = rs.getInt("tid");
            String tname = rs.getString("tname");
            String temail = rs.getString("temail");
            System.out.printf("%d : %s : %s\n", tid, tname, temail);
        }

        JDBCUtils1.close(rs, stmt, conn);
    }
}
