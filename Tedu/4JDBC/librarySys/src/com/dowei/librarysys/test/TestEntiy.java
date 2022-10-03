package com.dowei.librarysys.test;

import com.dowei.librarysys.entity.Author;
import com.dowei.librarysys.entity.Book;
import com.dowei.librarysys.entity.BookType;
import org.testng.annotations.Test;

public class TestEntiy {
    @Test
    public void TestBook(){
        Author author = new Author(1, "李白");
        BookType type = new BookType(1, "唐诗");
        Book book = new Book(1, "静夜思", author, 123456, type);
        System.out.println(book);
    }
}
