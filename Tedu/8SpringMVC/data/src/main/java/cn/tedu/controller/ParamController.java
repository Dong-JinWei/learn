package cn.tedu.controller;

import cn.tedu.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ParamController {

    @RequestMapping("/a")
    public ModelAndView paramTest(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", name);
        mav.addObject("pwd", pwd);
        mav.setViewName("ok.jsp");
        return mav;
    }

    @RequestMapping("/b")
    public ModelAndView paramBean(User user) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("id", user.getId());
        mav.addObject("user", user.getName());
        mav.addObject("pwd", user.getPwd());
        mav.setViewName("ok.jsp");
        return mav;
    }

    @RequestMapping("/c")
    public void httpParam(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String id = request.getParameter("id");
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        System.out.println(id);
        System.out.println(user);
        System.out.println(pwd);
        session.setAttribute("age", 21);
        session.setAttribute("id", id);
        session.setAttribute("user", user);
        session.setAttribute("pwd", pwd);
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/ok.jsp");
    }

    @RequestMapping("/d/{a}/{b}/{c}")
    public ModelAndView restful(@PathVariable("a") Integer id, @PathVariable("b") String user, @PathVariable("c") String pwd) {
        System.out.println(id);
        System.out.println(user);
        System.out.println(pwd);
        ModelAndView mav = new ModelAndView();
        mav.addObject("id", id);
        mav.addObject("user", user);
        mav.addObject("pwd", pwd);
        mav.setViewName("/ok.jsp");
        return mav;
    }
}
