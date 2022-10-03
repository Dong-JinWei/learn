package com.book.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.app.aop.SystemControllerLog;
import com.book.app.entity.TbUser;
import com.book.app.service.TbUserService;
import com.book.app.tools.CommonResult;
import com.book.app.tools.FtpUtil;
import com.book.app.tools.IDUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * (TbUser)表控制层
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:27
 */
@RestController
@RequestMapping("tbUser")
@Api(tags = "用户控制器")
@CrossOrigin
public class TbUserController {
    /**
     * 服务对象
     */
    @Resource
    private TbUserService tbUserService;


    @Value("${FTP.ADDRESS}")
    private String host;
    // 端口
    @Value("${FTP.PORT}")
    private int port;
    // ftp用户名
    @Value("${FTP.USERNAME}")
    private String userName;
    // ftp用户密码
    @Value("${FTP.PASSWORD}")
    private String passWord;
    // 文件在服务器端保存的主目录
    @Value("${FTP.BASEPATH}")
    private String basePath;
    // 访问图片时的基础url
    @Value("${IMAGE.BASE.URL}")
    private String baseUrl;


    String url;


    @SystemControllerLog(description = "登陆")
    @ApiOperation("登陆")
    @GetMapping("/login")
    public CommonResult login(String uname, String password) {
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname", uname);
        TbUser user = tbUserService.getOne(queryWrapper);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return CommonResult.success(user, "登陆成功");
            } else {
                return CommonResult.failed("error");
            }
        }
        return CommonResult.failed("no");
    }


    @SystemControllerLog(description = "查询所有用户")
    @ApiOperation("查询所有用户")
    @GetMapping("/list")
    public CommonResult list() {
        return CommonResult.success(tbUserService.list());
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, example = "1", value = "分页起始位置"),
            @ApiImplicitParam(name = "size", required = true, example = "10", value = "每页显示最多的数据"),
            @ApiImplicitParam(name = "uname", required = false, example = "", value = "根据用户名查询")
    })
    @SystemControllerLog(description = "分页查询所有用户")
    @ApiOperation("分页查询所有用户")
    @GetMapping("/listPage")
    public CommonResult listPage(int page, int size, String uname) {
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        if (!"".equals(uname) && uname != null) {
            queryWrapper.like("uname", uname);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("total", tbUserService.count(queryWrapper));
        map.put("rows", tbUserService.page(new Page(page, size), queryWrapper).getRecords());
        return CommonResult.success(map);
    }


    @SystemControllerLog(description = "添加一位用户")
    @ApiOperation("添加一位用户")
    @PostMapping("/save")
    public CommonResult save(@RequestBody TbUser user) {
        user.setImages(url);
        boolean save = tbUserService.save(user);
        return CommonResult.success(save);
    }


    @SystemControllerLog(description = "上传图片")
    @PostMapping("/getImagesUrl")
    public CommonResult getImagesUrl(@RequestParam("file") MultipartFile file) {

        try { // 1、给上传的图片生成新的文件名
            // 1.1获取原始文件名
            String oldName = file.getOriginalFilename();

            // 1.2使用IDUtils工具类生成新的文件名，新文件名 = newName + 文件后缀
            String newName = IDUtils.genImageName();
            newName = newName + oldName.substring(oldName.lastIndexOf("."));

            // 2、把图片上传到图片服务器
            // 2.1获取上传的io流
            InputStream input = file.getInputStream();

            boolean result = FtpUtil.uploadFile(host, port, userName, passWord, basePath, newName, input);

            if (result) {
                // 返回给前端图片访问路径
                url = baseUrl + "/" + newName;
            } else {
                return CommonResult.failed("上传失败");
            }


        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.failed("出现异常，上传失败");
        }

        return CommonResult.success(url);

    }


    @SystemControllerLog(description = "修改用户信息")
    @ApiOperation("修改用户信息")
    @PostMapping("/update")
    public CommonResult update(@RequestBody TbUser user) {
        return CommonResult.success(tbUserService.update(user));
    }

    @SystemControllerLog(description = "修改用户状态信息")
    @ApiOperation("修改用户状态信息")
    @PostMapping("/changeStat")
    public CommonResult changeStat(@RequestBody TbUser user) {
        return CommonResult.success(tbUserService.updateStat(user));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id")
    })
    @ApiOperation("删除用户")
    @SystemControllerLog(description = "删除用户")
    @PostMapping("/remove")
    public CommonResult remove(Integer uid) {
        return CommonResult.success(tbUserService.removeById(uid));
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id")
    })
    @SystemControllerLog(description = "上传图片")
    @PostMapping("/uploadImages")
    public CommonResult uploadImages(Integer uid, HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file) throws URISyntaxException {

        TbUser tbUser = tbUserService.getById(uid);
        try { // 1、给上传的图片生成新的文件名
            // 1.1获取原始文件名
            String oldName = file.getOriginalFilename();

            // 1.2使用IDUtils工具类生成新的文件名，新文件名 = newName + 文件后缀
            String newName = IDUtils.genImageName();
            newName = newName + oldName.substring(oldName.lastIndexOf("."));

            // 2、把图片上传到图片服务器
            // 2.1获取上传的io流
            InputStream input = file.getInputStream();

            boolean result = FtpUtil.uploadFile(host, port, userName, passWord, basePath, newName, input);

            if (result) {
                // 返回给前端图片访问路径
                String url = baseUrl + "/" + newName;
                tbUser.setImages(url);
            } else {
                return CommonResult.failed("上传失败");
            }


        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.failed("出现异常，上传失败");
        }

        return CommonResult.success(tbUserService.updateImagesInt(tbUser), "上传成功");

    }

    //    获取IP、端口号
    private URI getHost(URI uri) {
        URI effectiveURI;
        try {
            effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
        } catch (URISyntaxException e) {
            effectiveURI = null;
        }
        return effectiveURI;
    }


}

