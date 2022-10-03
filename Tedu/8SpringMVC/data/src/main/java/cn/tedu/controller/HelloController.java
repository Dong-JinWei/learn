package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/a.do")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", "admin");
        modelAndView.addObject("pwd", "1123456");
        modelAndView.setViewName("ok.jsp");
        return modelAndView;
    }
}
