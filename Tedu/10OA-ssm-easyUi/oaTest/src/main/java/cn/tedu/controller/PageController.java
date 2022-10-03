package cn.tedu.controller;

import cn.tedu.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/*专门用于处理页面的响应的控制器*/
@Controller
public class PageController {

    @Resource
    UserService userService;

    @RequestMapping({"/index", "/"})
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "index.jsp";
    }

    @RequestMapping("/login")
    public String login(){
        return "login.jsp";
     }

    @RequestMapping("/doLogin")
    public String doLogin(){
        return "index.jsp";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "login.jsp";
    }


}
