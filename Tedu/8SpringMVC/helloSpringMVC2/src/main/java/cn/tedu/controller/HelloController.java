package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping("/a.do")
    public ModelAndView f() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", "admin");
        mv.addObject("pwd", "123456");
        mv.setViewName("ok.jsp");
        return mv;
    }
}
