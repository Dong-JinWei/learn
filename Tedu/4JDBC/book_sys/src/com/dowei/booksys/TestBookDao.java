package com.dowei.booksys;

import org.testng.annotations.Test;

import java.util.List;

public class TestBookDao {
    BookDao dao = new BookDao();
    @Test
    public void TestAddBook(){
        Book book = new Book(null, "仿生人会梦到电子羊吗", 200123, "菲利普-迪克", "科幻小说");
        dao.addBook(book);
    }

    @Test
    public void TestDelBook(){
        dao.delBook(1);
    }

    @Test
    public void TestUpdateBook(){
        Book book = new Book(2, "女生徒", 200123, "太宰治", "科幻小说");
        dao.updateBook(book);
    }

    @Test
    public void TestGetOneBook(){
        Book book = dao.getOneBook(2);
        System.out.println(book);
    }
    
    @Test
    public void TestGetAllBook(){
        List<Book> book = dao.getAllBook();
        for (int i = 0; i < book.size(); i++) {
            System.out.println(book.get(i));
        }
    }
}
