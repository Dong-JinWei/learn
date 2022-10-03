package com.book.app;

import com.book.app.entity.TbBook;
import com.book.app.service.TbBookService;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {

    @Autowired
    private TbBookService tbBookService;

    @Test
    public void testList(){
        List<TbBook> list = tbBookService.list();
        for (TbBook tbBook : list) {
            System.out.println(tbBook);
        }
    }

}
