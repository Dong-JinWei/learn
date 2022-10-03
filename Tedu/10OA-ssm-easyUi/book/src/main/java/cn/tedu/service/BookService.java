package cn.tedu.service;

import cn.tedu.pojo.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAll(String bname, Integer page, Integer rows);

    public boolean insertBook(Book book);

    public int count();

    public int remove(List<Integer> list);


}
