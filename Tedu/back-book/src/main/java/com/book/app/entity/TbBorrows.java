package com.book.app.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TbBorrows)表实体类
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:26
 */
@SuppressWarnings("serial")

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_borrows")
@ApiModel("借阅")
public class TbBorrows implements Serializable {
    // 借阅ID
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(name = "boid", value = "借阅id", dataType = "Integer")
    private Integer boid;
    // 图书id
    @TableField(exist = false)
    @ApiModelProperty(name = "tbBook", value = "图书", dataType = "TbBook")
    private TbBook tbBook;
    // 借出

    @ApiModelProperty(name = "outtime", value = "借出时间", dataType = "String")
    private String outtime;
    // 归还
    @ApiModelProperty(name = "intime", value = "归还时间", dataType = "String")
    private String intime;

    @ApiModelProperty(name = "quantity", value = "借阅数量", dataType = "Integer")
    private Integer quantity;

    @ApiModelProperty(name = "names", value = "借阅者", dataType = "String")
    private String names;
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    private String createtime;
    // 修改时间
    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(hidden = true)
    private String modifytime;

    @TableLogic
    @ApiModelProperty(hidden = true)
    private Integer deleted;

    @ApiModelProperty(hidden = true)
    private Integer stat;

}

