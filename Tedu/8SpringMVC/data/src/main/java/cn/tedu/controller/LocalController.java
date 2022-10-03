package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class LocalController {

    @RequestMapping("/a")
    public String f(){
        ModelAndView modelAndView = new ModelAndView();
        return "/ok";
    }
}
