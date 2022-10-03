package com.dowei.booksys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public void addBook(Book book){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into tb_book values(null, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book.getBookTitle());
            pstmt.setInt(2, book.getBookNumber());
            pstmt.setString(3, book.getBookAuthor());
            pstmt.setString(4, book.getBookType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
    }

    public void delBook(int bookId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from tb_book where book_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
    }

    public int updateBook(Book book){
        Connection conn = null;
        int effect = 0;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update tb_book set book_title = ?, book_number = ?, book_author = ?, book_type = ? where book_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book.getBookTitle());
            pstmt.setInt(2, book.getBookNumber());
            pstmt.setString(3, book.getBookAuthor());
            pstmt.setString(4, book.getBookType());
            pstmt.setInt(5, book.getBookId());
            effect = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return effect;
    }

    public Book getOneBook(int bookId){

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Book book = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from tb_book where book_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookId);
            rs = pstmt.executeQuery();
            if (rs.next()){
                String bookTitle = rs.getString("book_title");
                Integer bookNumber = rs.getInt("book_number");
                String bookAuthor = rs.getString("book_author");
                String bookType = rs.getString("book_type");
                book = new Book(bookId, bookTitle, bookNumber, bookAuthor, bookType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return book;
    }

    public List<Book> getAllBook(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Book> books = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from tb_book";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            books = new ArrayList<>();
            while(rs.next()){
                int bookId = rs.getInt("book_id");
                String bookTitle = rs.getString("book_title");
                int bookNumber = rs.getInt("book_number");
                String bookAuthor = rs.getString("book_author");
                String bookType = rs.getString("book_type");
                Book book = new Book(bookId, bookTitle, bookNumber, bookAuthor, bookType);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return books;
    }
}
