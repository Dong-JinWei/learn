package cn.tedu.dao;

import cn.tedu.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {


    public List<Book> findAll(@Param("bname") String bname, @Param("page") Integer page, @Param("rows") Integer rows);

    public int count();

    public int insertBook(Book book);

    //public int edit(Book book);

    public int remove(List<Integer> list);

}
