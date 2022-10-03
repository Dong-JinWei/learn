package cn.tedu.controller;

import cn.tedu.domain.User;
import cn.tedu.service.UserService;
import org.jcp.xml.dsig.internal.dom.DOMSubTreeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public Map<String, Object> findAll(String uname, Integer page, Integer rows) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", userService.findAll(uname, page, rows)); // 当前页面显示内容
        map.put("total", userService.count(uname)); // 更具用户查实的总条数
        return map;
    }

    @RequestMapping("/save")
    public boolean save(User user) {
        return userService.save(user);
    }


    //@RequestMapping("/getuid")
    //public User getUser(Integer uid) {
    //    User user = userService.getUserById(uid);
    //    Integer id = user.getUid();
    //    System.out.println(id);
    //    return user;
    //}

    @RequestMapping("/uploadImages")
    public boolean uploadImages(Integer uid, MultipartFile file, HttpSession session) throws IOException {

        //获得上传文件名称，判断后缀是否.png名称，不是就不执行后面上传代码
        String originalFilename = file.getOriginalFilename();
        if (!originalFilename.endsWith(".png")) {
            return false;
        }
//查询需要上传的对象的数据
        User user = userService.getUserById(uid);
//获取当前项目部署的绝对路径
        String realPath = session.getServletContext().getRealPath("/");
//截取除项目名以外的路径
        String substring = realPath.substring(0, realPath.indexOf("OASystem"));
//文件上传路径 （需要在当前tomcat的webapps下创建新文件加upload）
        String uploadPath = substring + "upload";
//上传文件的新名称
        String newFileName = UUID.randomUUID().toString() + ".png";
//创建文件
        File filePath = new File(uploadPath, newFileName);
// 如果目录不存在则创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录：" + filePath);
        }
//真正的文件上传
        file.transferTo(filePath);
//由于要请求所以需要加上请求地址
        String url = "http://localhost:8080/upload/" + newFileName;
//将用户的头像数据设置进去
        user.setImages(url);
//调用修改方法刷新头像
        return userService.edit(user);
    }


    @RequestMapping("/edit")
    public boolean edit(User user){
        System.out.println(user);
        return userService.edit(user);
    }

    @RequestMapping("/batchRemove")
    public boolean batchRemove(@RequestParam("uids[]") List<Integer> list){

        return userService.remove(list);

    }
}
