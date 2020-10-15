package com.lim.test.swagger.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户信息
 */
@Data
@ApiModel
public class User {
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(name = "账号")
    private String account;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("姓名")
    private String name;
}
