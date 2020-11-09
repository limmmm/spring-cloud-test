package com.lim.test.swagger.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ApiModel 的 value将作为类型匹配依据
 *
 * @author lim
 * @since 2020/3/1
 */
@Data
@ApiModel(description = "用户信息")
public class User {

    @ApiModelProperty(value = "主键", example = "id1234")
    private String id;

    @ApiModelProperty(value = "账号", example = "test")
    private String account;

    @ApiModelProperty(value = "密码", example = "password")
    private String password;

    @ApiModelProperty(value = "姓名", example = "user1")
    private String name;

}
