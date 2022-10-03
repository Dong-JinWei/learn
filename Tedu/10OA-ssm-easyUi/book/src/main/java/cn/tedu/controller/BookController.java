package cn.tedu.controller;

import cn.tedu.pojo.Book;
import cn.tedu.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/findAll")
    public Map<String, Object> findAll(String bname, Integer page, Integer rows){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", bookService.findAll(bname, page, rows));
        map.put("total", bookService.count());
        return map;
    }

    @RequestMapping("/save")
    public boolean saveBook(Book book){
        System.out.println(book);
        return bookService.insertBook(book);
    }

    @RequestMapping("/remove")
    public boolean remove(@RequestParam("bids[]") List<Integer> list){
        System.out.println(list);
        return bookService.remove(list) > 0;
    }
}
