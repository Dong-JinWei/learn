package cn.tedu.service;

import cn.tedu.bean.BookDao;

public class BookServiceImp implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        System.out.println("setBookDao");
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
        System.out.println("book service save...");
    }
}
