package com.book.app.controller;


import com.alibaba.excel.EasyExcel;
import com.book.app.aop.SystemControllerLog;
import com.book.app.entity.TbBook;
import com.book.app.entity.TbCategory;
import com.book.app.service.TbBookService;
import com.book.app.tools.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * (TbBook)表控制层
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:24
 */
@RestController
@RequestMapping("tbBook")
@Api(tags = "图书控制器")
@CrossOrigin
public class TbBookController {
    /**
     * 服务对象
     */
    @Resource
    private TbBookService tbBookService;


    @GetMapping("/excel")
    @SystemControllerLog(description = "导出Excel")
    @ApiOperation("导出Excel")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("馆藏数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), TbBook.class).sheet("馆藏数据").doWrite(tbBookService.list());
    }

    @ApiOperation("查询分类数量")
    @GetMapping("/getCateNum")
    @SystemControllerLog(description = "查询分类数量")
    public CommonResult getCateNum() {
        return CommonResult.success(tbBookService.getCateNum());
    }


    @ApiOperation("查询馆藏数量")
    @GetMapping("/getAllQuantity")
    @SystemControllerLog(description = "查询馆藏数量")
    public CommonResult getAllQuantity() {
        return CommonResult.success(tbBookService.getAllQuantity());
    }


    @ApiOperation("查询所有图书")
    @GetMapping("/list")
    @SystemControllerLog(description = "查询所有图书")
    public CommonResult list() {
        return CommonResult.success(tbBookService.list());
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数", required = true),
            @ApiImplicitParam(name = "size", value = "每页显示多少条数据", required = true),
            @ApiImplicitParam(name = "bname", value = "根据名字查询")
    })
    @SystemControllerLog(description = "分页查询所有图书")
    @ApiOperation("分页查询所有图书")
    @GetMapping("/listPage")
    public CommonResult listPage(int page, int size, String bname) {
        Map<String, Object> map = new HashMap<>();
        map.put("total", tbBookService.count(bname));
        map.put("rows", tbBookService.listPage(page, size, bname));
        System.out.println(map.get("rows"));
        return CommonResult.success(map);
    }

    @SystemControllerLog(description = "增加图书信息")
    @ApiOperation("增加图书信息")
    @ApiImplicitParam(name = "cateid", value = "类别id", required = true)
    @PostMapping("/save")
    public CommonResult save(@RequestBody TbBook tbBook, Integer cateid) {
        TbCategory tbCategory = new TbCategory();
        tbCategory.setCateid(cateid);
        tbBook.setCategory(tbCategory);
        return CommonResult.success(tbBookService.save(tbBook));
    }

    @SystemControllerLog(description = "修改图书信息")
    @ApiOperation("修改图书信息")
    @PostMapping("/update")
    @ApiImplicitParam(name = "cateid", value = "类别id", required = true)
    public CommonResult update(@RequestBody TbBook tbBook, Integer cateid) {
        TbCategory tbCategory = new TbCategory();
        tbCategory.setCateid(cateid);
        tbBook.setCategory(tbCategory);
        return CommonResult.success(tbBookService.update(tbBook));
    }

    @SystemControllerLog(description = "删除图书")
    @ApiOperation("删除图书")
    @ApiImplicitParam(name = "bid", value = "图书id", required = true)
    @PostMapping("/remove")
    public CommonResult remove(Integer bid) {
        return CommonResult.success(tbBookService.removeById(bid));
    }


}

