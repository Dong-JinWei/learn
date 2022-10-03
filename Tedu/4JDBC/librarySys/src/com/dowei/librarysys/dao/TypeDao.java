package com.dowei.librarysys.dao;

import com.dowei.librarysys.entity.BookType;
import com.dowei.librarysys.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDao {
    //增加类型
    public int addType(BookType type) {
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into tb_type values(null,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, type.getTypeName());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    //删除类型
    public int delType(int typeId) {
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from tb_type where type_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, typeId);
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    //修改类型
    public int updateType(BookType type) {
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update tb_type set type_name = ? where type_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, type.getTypeName());
            pstmt.setInt(2, type.getTypeId());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    //查询一个类型
    public BookType getOneType(int typeId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BookType type = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select type_id, type_name from tb_type where type_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, typeId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                type = new BookType(typeId, rs.getString("type_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return type;
    }

    //查询所有类型
    public List<BookType> getAllType() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<BookType> types = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select type_id, type_name from tb_type";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BookType type = new BookType(rs.getInt("type_id"), rs.getString("type_name"));
                types.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return types;
    }

    public List<BookType> getAllCountType() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<BookType> types = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT t.type_id, t.type_name, COUNT(b.type_id) AS type_num FROM tb_type AS t LEFT JOIN tb_book AS b ON t.type_id = b.type_id GROUP BY t.type_id ORDER BY t.type_id;";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BookType type = new BookType(rs.getInt("t.type_id"), rs.getString("t.type_name"), rs.getInt("type_num"));
                types.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return types;
    }

    public boolean isTypeExistByTypeName(String typeName){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select type_id, type_name from tb_type where type_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, typeName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return flag;
    }

    //查询一个类型
    public BookType getOneTypeByName(String typeName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BookType type = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select type_id, type_name from tb_type where type_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, typeName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                type = new BookType(rs.getInt("type_id"), typeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return type;
    }

}
