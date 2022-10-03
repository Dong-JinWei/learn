package cn.tedu.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    @RequestMapping("/test/model")
    public String model(Model model) {
        model.addAttribute("user", "pwd");
        return "/ok";
    }

    @RequestMapping("/test/model/map")
    public String model(ModelMap modelMap) {
        modelMap.addAttribute("user", "admin");
        modelMap.addAttribute("pwd", "123");
        return "/ok";
    }

    @RequestMapping("/test/map")
    public String model(Map<String, Object> map) {
        map.put("user", "admin");
        map.put("pwd", "123");
        return "/ok";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("user", "dowei");
        session.setAttribute("pwd", "123");
        return "/ok";
    }
    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("user", "dowei");
        servletContext.setAttribute("pwd", "123");
        return "/ok";
    }
}
