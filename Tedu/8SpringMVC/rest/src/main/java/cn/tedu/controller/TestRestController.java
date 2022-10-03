package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestRestController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("获取了所有用户");
        return "/ok";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("获取了id为"+id+"的用户");
        return "/ok";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(){
        System.out.println("通过post插入了一个用户");
        return "/ok";
    }
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("通过put修改了一个用户");
        return "/ok";
    }
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser(){
        System.out.println("通过delete删除了一个用户");
        return "/ok";
    }
}
