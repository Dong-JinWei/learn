package com.book.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.app.aop.SystemControllerLog;
import com.book.app.entity.TbCategory;
import com.book.app.service.TbCategoryService;
import com.book.app.tools.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (TbCategory)表控制层
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:26
 */
@RestController
@RequestMapping("tbCategory")
@Api(tags = "图书类别控制")
@CrossOrigin
public class TbCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private TbCategoryService tbCategoryService;


    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, example = "1", value = "分页起始位置"),
            @ApiImplicitParam(name = "size", required = true, example = "10", value = "每页显示最多的数据"),
            @ApiImplicitParam(name = "cname", required = false, example = "", value = "根据图书类别查询")
    })
    @ApiOperation("分页查询所有类别信息")
    @SystemControllerLog(description = "分页查询所有类别信息")
    @GetMapping("/listPage")
    public CommonResult listPage(int page, int size, String cname) {
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<TbCategory> queryWrapper = new QueryWrapper<>();
        if (!"".equals(cname) && cname != null) {
            queryWrapper.like("catename", cname);
        }
        map.put("total", tbCategoryService.count());
        map.put("rows", tbCategoryService.page(new Page(page, size), queryWrapper).getRecords());
        return CommonResult.success(map);
    }


    @ApiOperation("查询所有类别信息")
    @SystemControllerLog(description = "查询所有类别信息")
    @GetMapping("/list")
    public CommonResult list() {
        return CommonResult.success(tbCategoryService.list());
    }



    @ApiOperation("创建图书类别")
    @SystemControllerLog(description = "创建图书类别")
    @PostMapping("/save")
    public CommonResult save(@RequestBody TbCategory category) {
        return CommonResult.success(tbCategoryService.save(category));
    }


    @ApiOperation("修改图书类别")
    @SystemControllerLog(description = "修改图书类别")
    @PostMapping("/update")
    public CommonResult update(@RequestBody TbCategory category) {
        return CommonResult.success(tbCategoryService.updateById(category));
    }


    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "cateid",
                    value = "类别id"
            )
    })
    @ApiOperation("删除图书类别")
    @SystemControllerLog(description = "删除图书类别")
    @PostMapping("/remove")
    public CommonResult remove(Integer cateid) {
        return CommonResult.success(tbCategoryService.removeById(cateid));
    }

}

