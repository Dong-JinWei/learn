package com.book.app.entity;

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
 * (TbCategory)表实体类
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:26
 */
@SuppressWarnings("serial")


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_category")
@ApiModel("图书类别")
@EqualsAndHashCode
public class TbCategory implements Serializable {
    // 类别id
    @ApiModelProperty(name = "cateid", value = "图书类别id", dataType = "integer")
    @TableId(type = IdType.AUTO)
    @ExcelProperty("类别名字")
    private Integer cateid;
    // 类别名字
    @ApiModelProperty(name = "catename",required = true, value = "类别名称", dataType = "string")
    @ExcelProperty("创建时间")
    private String catename;
    // 创建时间
    @ApiModelProperty(hidden = true, dataType = "string")
    @TableField(fill = FieldFill.INSERT)
    @ExcelProperty("修改时间")
    private String createtime;
    // 修改时间
    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(hidden = true, dataType = "string")
    @ExcelProperty("修改时间")
    private String modifytime;
    // 0 未删除 1 删除
    @TableLogic
    @ApiModelProperty(hidden = true, dataType = "Integer")
    @ExcelProperty("是否删除")
    private Integer deleted;


}

