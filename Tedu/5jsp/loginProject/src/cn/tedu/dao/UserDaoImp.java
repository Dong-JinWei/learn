package cn.tedu.dao;

import cn.tedu.bean.User;
import cn.tedu.util.JDBCUtile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp implements UserDao {
    @Override
    public int findUser(User user) {
        Connection conn = JDBCUtile.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int res = -1;
        try {
            String sql = "select COUNT(*) from user_table where u_name=? and u_password=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            rs = pstm.executeQuery();
            if (rs.next()) {
                res = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtile.close(rs, pstm, conn);
        }
        return res;
    }

    @Override
    public int addUser(User user) {

        Connection conn = null;
        PreparedStatement pstm = null;
        int effect = -1;
        try {
            conn = JDBCUtile.getConnection();
            String sql = "INSERT INTO user_table(u_name, u_password) VALUES(?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            effect = pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtile.close(pstm, conn);
        }
        return effect;
    }

    @Override
    public int findUserByName(String username) {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int effect = -1;
        try {
            conn = JDBCUtile.getConnection();
            String sql = "select count(*) from user_table where u_name = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            if (rs.next()){
                effect = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtile.close(rs, pstm, conn);
        }
        return effect;
    }
}
