package com.dowei.librarysys.dao;

import com.dowei.librarysys.entity.Author;
import com.dowei.librarysys.entity.Book;
import com.dowei.librarysys.entity.BookType;
import com.dowei.librarysys.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    //增加书籍
    public int addBook(Book book) {
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into tb_book values(null,?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book.getBookTitle());
            pstmt.setInt(2, book.getAuthor().getAuthorId());
            pstmt.setInt(3, book.getBookISBN());
            pstmt.setInt(4, book.getType().getTypeId());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    //删除书籍
    public int delBook(int bookId) {
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from tb_book where book_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookId);
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    //修改书籍
    public int updateBook(Book book) {
        int effect = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update tb_book set book_title = ?, author_id = ?, book_isbn = ?, type_id = ? where book_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book.getBookTitle());
            pstmt.setInt(2, book.getAuthor().getAuthorId());
            pstmt.setInt(3, book.getBookISBN());
            pstmt.setInt(4, book.getType().getTypeId());
            pstmt.setInt(5, book.getBookId());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    //查询一个书籍
    public Book getOneBook(int bookId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BookType type = null;
        Book book = null;
        Author author = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT b.book_id, b.book_title, a.author_name, t.type_name, b.book_isbn FROM tb_book AS b LEFT JOIN tb_author AS a ON b.`author_id` = a.`author_id` LEFT JOIN tb_type AS t ON b.`type_id` = t.`type_id` WHERE b.`book_id` = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                type = new BookType(null, rs.getString("t.type_name"));
                author = new Author(null, rs.getString("a.author_name"));
                book = new Book(bookId, rs.getString("b.book_title"), author,  rs.getInt("b.book_isbn"), type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return book;
    }

    //查询所有书籍
    public List<Book> getAllBook() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Book> books = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT b.book_id, b.book_title, a.author_name, t.type_name, b.book_isbn FROM tb_book AS b LEFT JOIN tb_author AS a ON b.`author_id` = a.`author_id` LEFT JOIN tb_type AS t ON b.`type_id` = t.`type_id`";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BookType type = new BookType(null, rs.getString("t.type_name"));
                Author author = new Author(null, rs.getString("a.author_name"));
                Book book = new Book(rs.getInt("b.book_id"), rs.getString("b.book_title"), author,  rs.getInt("b.book_isbn"), type);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return books;
    }

    public boolean isISBNExist(int bookISBN) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT * from tb_book WHERE  book_isbn = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookISBN);
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



}
