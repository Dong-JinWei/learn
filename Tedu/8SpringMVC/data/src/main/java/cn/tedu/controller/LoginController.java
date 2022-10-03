package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView loginTest(String username, String password){
        ModelAndView mav = new ModelAndView();
        if ("admin".equals(username) && "123456".equals((password))){
            mav.setViewName("ok");
        }else {
            mav.setViewName("fail");
        }
        System.out.println(username + "," + password);

        return mav;
    }
}
