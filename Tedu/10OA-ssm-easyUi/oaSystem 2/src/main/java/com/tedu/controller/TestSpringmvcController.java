package com.tedu.controller;

import com.tedu.dao.UserDao;
import com.tedu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
public class TestSpringmvcController {

   // @Autowired
    UserDao userDao;


    /*@RequestMapping("/testmvc")
    public List<User> testMVC(){
        //5.调用方法查询.
        List<User> users = userDao.findAll();

        return users;

    }*/
}
