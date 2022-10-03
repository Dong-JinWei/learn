import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public int addUser(User user){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int effect = -1;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into user values(null, ?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }
    public int selectUser(User user){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int num = -1;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select count(*) from user where username=? and password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            rs = pstmt.executeQuery();
            if (rs.next()){
                num = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return num;
    }
}
