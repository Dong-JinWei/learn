package com.dowei.empsys.dao;

import com.dowei.empsys.entity.User;
import com.dowei.empsys.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.dowei.empsys.utils.JDBCUtils.*;

public class UserDao {
    //增加用户
    public int addUser(User user){
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            effect = 0;
            conn = getConnection();
            String sql = "insert into tb_user values (null, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getNickname());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt, conn);
        }
        return effect;
    }

    //删除用户
    public int deleteUser(int userId){
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            effect = 0;
            conn = getConnection();
            String sql = "delete from tb_user where user_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    //修改用户
    public int updateUser(User user){
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            effect = 0;
            conn = getConnection();
            String sql = "update tb_user set password = ?, nickname = ? where user_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getNickname());
            pstmt.setInt(3, user.getUserId());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    //查询一个用户
    public User getOneUser(int userId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = getConnection();
            String sql = "select user_id, username, password, nickname from tb_user where user_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            user = null;
            if (rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                user = new User(userId, username, password, nickname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return user;
    }
    //查询所有用户
    public List<User> getAllUser(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        List<User> users = new ArrayList<>();
        try {
            conn = getConnection();
            String sql = "select user_id, username, password, nickname from tb_user";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                int userId = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                user = new User(userId, username, password, nickname);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return users;
    }

    //查询一个用户，根据用户名
    public User getOneUserByUsername(String username){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = getConnection();
            String sql = "select user_id, username, password, nickname from tb_user where username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (rs.next()){
                int userId = rs.getInt("user_id");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                user = new User(userId, username, password, nickname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return user;
    }
}
