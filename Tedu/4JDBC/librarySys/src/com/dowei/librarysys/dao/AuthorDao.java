package com.dowei.librarysys.dao;

import com.dowei.librarysys.entity.Author;
import com.dowei.librarysys.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {
    //增加作者
    public int addAuthor(Author author){
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into tb_author values(null,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, author.getAuthorName());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt,conn);
        }
        return effect;
    }

    //删除作者
    public int delAuthor(int authorId){
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from tb_author where author_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, authorId);
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt,conn);
        }
        return effect;
    }

    //修改作者
    public int updateAuthor(Author author){
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update tb_author set author_name = ? where author_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, author.getAuthorName());
            pstmt.setInt(2, author.getAuthorId());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt,conn);
        }
        return effect;
    }

    //查询一个作者
    public Author getOneAuthor(int authorId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Author author = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select author_id, author_name from tb_author where author_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,authorId);
            rs = pstmt.executeQuery();
            if (rs.next()){
                author = new Author(authorId, rs.getString("author_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return author;
    }

    //查询所有作者
    public List<Author> getAllAuthor(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Author> authors = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select author_id, author_name from tb_author";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Author author = new Author(rs.getInt("author_id"), rs.getString("author_name"));
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return authors;
    }

    //查询所有作者以及作者的作品数
    public List<Author> getAllCountAuthor(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Author> authors = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT a.author_id, a.author_name, COUNT(b.author_id) AS author_num FROM tb_author AS a LEFT JOIN tb_book AS b ON a.author_id = b.author_id GROUP BY a.author_id;";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Author author = new Author(rs.getInt("a.author_id"), rs.getString("a.author_name"), rs.getInt("author_num"));
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return authors;
    }

    //查询作者是否存在
    public boolean isAuthorExist(String authorName){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select author_id, author_name from tb_author where author_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,authorName);
            rs = pstmt.executeQuery();
            if (rs.next()){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return flag;
    }

    public Author getAuthorByName(String authorName){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Author author = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select author_id, author_name from tb_author where author_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,authorName);
            rs = pstmt.executeQuery();
            if (rs.next()){
                int authorId = rs.getInt("author_id");
                author = new Author(authorId, authorName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return author;
    }
}
