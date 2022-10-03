package com.book.app.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TbLog)表实体类
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:27
 */
@SuppressWarnings("serial")

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_log")
@ApiModel("日志")
public class TbLog implements Serializable {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(name = "operid", value = "日志id", dataType = "Integer")
    private Integer operid;

    @ApiModelProperty(name = "opertime", value = "操作时间", dataType = "String")
    @TableField(fill = FieldFill.INSERT)
    private String createtime;

    @ApiModelProperty(name = "ip", value = "操作id", dataType = "String")
    private String ip;

    @ApiModelProperty(name = "methods", value = "操作方法", dataType = "String")
    private String methods;

    // @ApiModelProperty(name = "ddesc", value = "操作描述", dataType = "String")
    private String ddesc;


}

