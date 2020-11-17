package com.lim.test.mybatisplus.role.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Lim
 * @since 2020/2/19
 */
public enum RoleTypeEnum {

    TYPE1(1, "类型1"), TYPE2(2, "类型2"), TYPE3(3, "类型3");

    @EnumValue
    @JsonValue
    private final int type;

    private final String description;

    RoleTypeEnum(int type, String description) {
        this.type = type;
        this.description = description;
    }
}
