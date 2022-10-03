package com.book.app.controller;


import com.book.app.aop.SystemControllerLog;
import com.book.app.entity.TbBook;
import com.book.app.entity.TbBorrows;
import com.book.app.service.TbBorrowsService;
import com.book.app.tools.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * (TbBorrows)表控制层
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:26
 */
@RestController
@RequestMapping("tbBorrows")
@Api(tags = "借阅信息控制器")
@CrossOrigin
public class TbBorrowsController {
    /**
     * 服务对象
     */
    @Resource
    private TbBorrowsService tbBorrowsService;


    @ApiOperation("获取借阅数最多的图书")
    @GetMapping("/getFirstBook")
    @SystemControllerLog(description = "获取借阅数最多的图书")
    public CommonResult getFirstBook() {
        return CommonResult.success(tbBorrowsService.getFirstBook());
    }


    @ApiOperation("获取借阅数最多的用户名")
    @GetMapping("/getFirstName")
    @SystemControllerLog(description = "获取借阅数最多的用户名")
    public CommonResult getFirstName() {
        return CommonResult.success(tbBorrowsService.getFirstName());
    }


    @ApiOperation("查询所有借阅数量")
    @GetMapping("/getAllQuantity")
    @SystemControllerLog(description = "查询所有借阅数量")
    public CommonResult getAllQuantity() {
        return CommonResult.success(tbBorrowsService.getAllQuantity());
    }


    @SystemControllerLog(description = "查询所有借阅信息")
    @ApiOperation("查询所有借阅信息")
    @GetMapping("/list")
    public CommonResult list() {
        return CommonResult.success(tbBorrowsService.list());
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, example = "1", value = "分页起始位置"),
            @ApiImplicitParam(name = "size", required = true, example = "10", value = "每页显示最多的数据"),
            @ApiImplicitParam(name = "keywords", required = false, example = "", value = "查询关键字")
    })
    @SystemControllerLog(description = "分页查询所有借阅信息")
    @ApiOperation("分页查询所有借阅信息")
    @GetMapping("/listPage")
    public CommonResult listPage(int page, int size, String keywords) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", tbBorrowsService.count(keywords));
        map.put("rows", tbBorrowsService.listPage(page, size, keywords));
        return CommonResult.success(map);
    }

    @SystemControllerLog(description = "增加借阅信息")
    @ApiImplicitParam(name = "bid", required = true, value = "图书ID")
    @ApiOperation("增加借阅信息")
    @PostMapping("/save")
    public CommonResult save(@RequestBody TbBorrows tbBorrows, Integer bid) {
        TbBook tbBook = new TbBook();
        tbBook.setBid(bid);
        tbBorrows.setTbBook(tbBook);
        return CommonResult.success(tbBorrowsService.save(tbBorrows));
    }

    @SystemControllerLog(description = "修改借阅数量")
    @ApiOperation("修改借阅数量")
    @PostMapping("/giveback")
    @ApiImplicitParam(name = "bid", required = true, value = "图书ID")
    public CommonResult giveback(@RequestBody TbBorrows tbBorrows, Integer bid) {
        TbBook tbBook = new TbBook();
        tbBook.setBid(bid);
        tbBorrows.setTbBook(tbBook);
        return CommonResult.success(tbBorrowsService.giveback(tbBorrows));
    }

    @SystemControllerLog(description = "修改借阅数量")
    @ApiOperation("修改借阅数量")
    @PostMapping("/changeStat")
    public CommonResult changeStat(@RequestBody TbBorrows tbBorrows) {
        return CommonResult.success(tbBorrowsService.changeStat(tbBorrows));
    }


    @SystemControllerLog(description = "修改借阅信息")
    @ApiImplicitParam(name = "bid", required = true, value = "图书ID")
    @ApiOperation("修改借阅信息")
    @PostMapping("/update")
    public CommonResult update(@RequestBody TbBorrows tbBorrows, Integer bid) {
        TbBook tbBook = new TbBook();
        tbBook.setBid(bid);
        tbBorrows.setTbBook(tbBook);
        return CommonResult.success(tbBorrowsService.update(tbBorrows));
    }

    @SystemControllerLog(description = "删除借阅信息")
    @ApiOperation("删除借阅信息")
    @ApiImplicitParam(name = "bid", value = "借阅信息id", required = true)
    @PostMapping("/remove")
    public CommonResult remove(Integer boid) {
        return CommonResult.success(tbBorrowsService.removeById(boid));
    }


}

