package cn.tedu.service.impl;

import cn.tedu.dao.BookDao;
import cn.tedu.pojo.Book;
import cn.tedu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    public List<Book> findAll(String bname, Integer page, Integer rows) {
        return bookDao.findAll(bname, (page - 1) * rows, rows);
    }

    public boolean insertBook(Book book) {
        return bookDao.insertBook(book) > 0;
    }

    public int count() {
        return bookDao.count();
    }

    public int remove(List<Integer> list) {
        return bookDao.remove(list);
    }
}
