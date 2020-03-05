package com.lim.test.base.sys.entity;

import com.lim.test.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author lim
 * @since 2020-03-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysUser对象", description="用户信息表")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账号名")
    private String account;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private Boolean sex;

    @ApiModelProperty(value = "手机号国家编码")
    private String phoneNationCode;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "固话")
    private String tel;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    @ApiModelProperty(value = "密码")
    private String pwd;

    @ApiModelProperty(value = "头像图片id")
    private String avatarId;


}
