package com.book.app.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TbUser)表实体类
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:27
 */
@SuppressWarnings("serial")

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_user")
@ApiModel("用户")
public class TbUser implements Serializable {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(name = "uid", value = "用户id", dataType = "Integer")
    private Integer uid;

    @ApiModelProperty(name = "uname", value = "用户名称", dataType = "String")
    private String uname;

    @ApiModelProperty(name = "password", value = "用户密码", dataType = "String")
    private String password;

    @ApiModelProperty(name = "images", value = "用户头像", dataType = "String")
    private String images;

    @ApiModelProperty(name = "stat", value = "用户状态", dataType = "Integer")
    private Integer stat;

    @ApiModelProperty(name = "sex", value = "性别", dataType = "String")
    private String sex;

    @ApiModelProperty(hidden = true, dataType = "String")
    @TableField(fill = FieldFill.INSERT)
    private String createtime;
    // 修改时间

    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(hidden = true, dataType = "String")
    private String modifytime;
    // 0 未删除 1 删除
    @TableLogic
    @ApiModelProperty(hidden = true, dataType = "Integer")
    private Integer deleted;


}

