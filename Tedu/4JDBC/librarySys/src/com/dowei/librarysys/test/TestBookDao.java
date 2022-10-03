package com.dowei.librarysys.test;

import com.dowei.librarysys.dao.BookDao;
import com.dowei.librarysys.entity.Author;
import com.dowei.librarysys.entity.Book;
import com.dowei.librarysys.entity.BookType;
import org.testng.annotations.Test;

import java.util.List;

public class TestBookDao {
    BookDao dao = new BookDao();

    @Test
    public void testInsert(){
        Author author = new Author(3, "李白");
        BookType type = new BookType(2, "唐诗");
        Book book = new Book(null, "静夜思", author, 123456, type);
        dao.addBook(book);
    }

    @Test
    public void testUpdate(){
        Author author = new Author(3, "杜甫");
        BookType type = new BookType(2, "宋词");
        Book book = new Book(1, "茅屋为秋风所破歌", author, 123456, type);
        dao.updateBook(book);
    }

    @Test
    public void testDel(){
        dao.delBook(1);
    }

    @Test
    public void testGetOne(){
        Book oneBook = dao.getOneBook(2);
        System.out.println(oneBook);
    }

    @Test
    public void testGetAll(){
        List<Book> allBook = dao.getAllBook();
        for(Book book: allBook){
            System.out.println(book);
        }
    }

    @Test
    public void testISBN(){
        boolean isbnExist = dao.isISBNExist(123456);
        System.out.println(isbnExist);
    }

}
