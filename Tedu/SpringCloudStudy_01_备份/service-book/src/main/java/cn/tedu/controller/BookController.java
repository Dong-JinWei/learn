package cn.tedu.controller;

import cn.tedu.pojo.Book;
import cn.tedu.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {

    @Resource
    BookService bookService;

    @RequestMapping("/book/{bid}")
    public Book findBookById(@PathVariable("bid") int bid){
        System.out.println("我是book");
        return  bookService.getBookById(bid);
    }
}
