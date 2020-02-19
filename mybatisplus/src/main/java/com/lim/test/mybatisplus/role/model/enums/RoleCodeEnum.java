package com.lim.test.mybatisplus.role.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Lim
 * @date 2020/2/19
 */
public enum RoleCodeEnum {

    SUPER_ADMIN("super_admin", "超级管理员"),
    ADMIN("admin", "管理员"),
    VISITOR("visitor", "访客");

    @EnumValue
    @JsonValue
    private final String code;

    private final String description;

    RoleCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
