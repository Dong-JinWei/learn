package com.dowei.librarysys.test;

import com.dowei.librarysys.dao.AuthorDao;
import com.dowei.librarysys.entity.Author;
import org.testng.annotations.Test;

import java.util.List;

public class TestAuthorDao {
    AuthorDao dao = new AuthorDao();

    @Test
    public void TestAdd(){
        Author author = new Author(null, "李白");
        dao.addAuthor(author);
    }

    @Test
    public void TestUpdate(){
        Author author = new Author(1, "杜甫");
        dao.updateAuthor(author);
    }

    @Test
    public void TestDel(){
        dao.delAuthor(1);
    }

    @Test
    public void TestGetOne(){
        Author oneAuthor = dao.getOneAuthor(2);
        System.out.println(oneAuthor);
    }

    @Test
    public void TestGetAll(){
        List<Author> allAuthor = dao.getAllAuthor();
        for (Author author : allAuthor){
            System.out.println(allAuthor);
        }
    }

    @Test
    public void TestGetAllCountAuthor(){
        List<Author> allCountAuthor = dao.getAllCountAuthor();
        for (Author author : allCountAuthor) {
            System.out.println(author);
        }
    }
}
