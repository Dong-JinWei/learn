package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    //@RequestMapping("/test/view/thymeleaf")
    //public String testView(){
    //    return "/ok";
    //}

    // 转发
    @RequestMapping("/test/view/forward")
    public String testViewForward(){
        return "forward:/ok.jsp";
    }

    // 重定向
    @RequestMapping("/test/view/redirect")
    public String testViewRedirect(){
        return "redirect:/ok.jsp";
    }
}
