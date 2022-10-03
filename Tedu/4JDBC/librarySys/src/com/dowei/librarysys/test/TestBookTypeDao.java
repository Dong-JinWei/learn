package com.dowei.librarysys.test;

import com.dowei.librarysys.dao.TypeDao;
import com.dowei.librarysys.entity.BookType;
import org.testng.annotations.Test;

import java.util.List;

public class TestBookTypeDao {
    TypeDao dao = new TypeDao();

    @Test
    public void TestAddType(){
        BookType type = new BookType(null, "宋词");
        dao.addType(type);
    }

    @Test
    public void TestUpdateType(){
        BookType type = new BookType(1, "元曲");
        dao.updateType(type);
    }

    @Test
    public void TestDelType(){
        dao.delType(1);
    }

    @Test
    public void TestGetType(){
        BookType oneType = dao.getOneType(2);
        System.out.println(oneType);
    }

    @Test
    public void TestGetAllType(){
        List<BookType> allType = dao.getAllType();
        for(BookType type: allType){
            System.out.println(type);
        }
    }
}
