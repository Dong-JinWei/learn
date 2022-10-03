package com.dowei.booksys;

public class Book {
    private Integer bookId;
    private String bookTitle;
    private Integer bookNumber;
    private String bookAuthor;
    private String bookType;

    public Book() {
    }

    public Book(Integer bookId, String bookTitle, Integer bookNumber, String bookAuthor, String bookType) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookNumber = bookNumber;
        this.bookAuthor = bookAuthor;
        this.bookType = bookType;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return  "书籍序号：" + bookId +
                "\n书名：" + bookTitle +
                "\n书籍编号：" + bookNumber +
                "\n作者：" + bookAuthor +
                "\n类型：" + bookType;
    }
}
