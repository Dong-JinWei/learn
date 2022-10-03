package com.book.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.app.aop.SystemControllerLog;
import com.book.app.entity.TbBook;
import com.book.app.service.TbLogService;
import com.book.app.tools.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (TbLog)表控制层
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:27
 */
@RestController
@RequestMapping("tbLog")
@CrossOrigin
@Api(tags = "日志控制器")
public class TbLogController {
    /**
     * 服务对象
     */
    @Resource
    private TbLogService tbLogService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数", required = true),
            @ApiImplicitParam(name = "size", value = "每页显示多少条数据", required = true)
    })
    @SystemControllerLog(description = "分页查询所有日志")
    @ApiOperation("分页查询所有日志")
    @GetMapping("/listPage")
    public CommonResult listPage(int page, int size) {
        Map<String, Object> map = new HashMap<>();
        map.put("total", tbLogService.count());
        map.put("rows", tbLogService.page(new Page(page, size)).getRecords());
        return CommonResult.success(map);
    }

}

