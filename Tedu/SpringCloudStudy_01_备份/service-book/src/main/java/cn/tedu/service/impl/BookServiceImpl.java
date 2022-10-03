package cn.tedu.service.impl;

import cn.tedu.mapper.BookMapper;
import cn.tedu.pojo.Book;
import cn.tedu.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public Book getBookById(int bid) {
        return bookMapper.getBookById(bid);
    }
}
