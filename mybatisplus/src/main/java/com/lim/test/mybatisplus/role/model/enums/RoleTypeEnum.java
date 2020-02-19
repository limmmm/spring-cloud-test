package com.lim.test.mybatisplus.role.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 *
 * @author Lim
 * @date 2020/2/19
 */
public enum RoleTypeEnum {

    TYPE1(1, "类型1"), TYPE2(2, "类型2"), TYPE3(3, "类型3");

    @EnumValue
    private final int type;

    private final String description;

    RoleTypeEnum(int type, String description) {
        this.type = type;
        this.description = description;
    }
}