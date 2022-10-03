package com.book.app.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TbBook)表实体类
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:25
 */
@SuppressWarnings("serial")

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_book")
@ApiModel("图书")
@EqualsAndHashCode
public class TbBook implements Serializable {
    // 图书id
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(name = "bid", value = "图书id", dataType = "Integer")
    @ExcelProperty("图书id")
    private Integer bid;
    // 图书编号
    @ApiModelProperty(name = "bnum", value = "图书编号", dataType = "String")
    @ExcelProperty("图书编号")
    private String bnum;
    // 图书名称
    @ApiModelProperty(name = "bname", value = "图书名称", dataType = "String")
    @ExcelProperty("图书名称")
    private String bname;
    // 价格

    @ApiModelProperty(name = "price", value = "图书价格", dataType = "Double")
    @ExcelProperty("图书价格")
    private Double price;
    // 作者
    @ApiModelProperty(name = "author", value = "图书作者", dataType = "String")
    @ExcelProperty("图书作者")
    private String author;
    // 简介
    @ApiModelProperty(name = "instruction", value = "图书介绍", dataType = "String")
    @ExcelProperty("图书介绍")
    private String instruction;
    // 库存数量
    @ApiModelProperty(name = "quantity", value = "库存数量", dataType = "Integer")
    @ExcelProperty("库存数量")
    private Integer quantity;
    // 创建时间
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    @ExcelProperty("创建时间")
    private String createtime;
    // 修改时间
    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(hidden = true)
    @ExcelProperty("修改时间")
    private String modifytime;
    // 0未删除 1删除
    @TableLogic
    @ApiModelProperty(hidden = true)
    @ExcelProperty("是否删除")
    private Integer deleted;
    // 类别外键
    @TableField(exist = false)
    // @ApiModelProperty(name = "category", value = "类别", dataType = "TbCategory")
    @ApiModelProperty(hidden = true)
    @ExcelIgnore
    private TbCategory category;

}

