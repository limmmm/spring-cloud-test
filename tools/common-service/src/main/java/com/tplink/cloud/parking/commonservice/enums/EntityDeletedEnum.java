package com.tplink.cloud.parking.commonservice.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 实体类逻辑删除字段deleted枚举值
 *
 * @author liming
 * @since 2020-09-27
 */
public enum EntityDeletedEnum {

    DELETED(true, "已逻辑删除"),
    NORMAL(false, "未逻辑删除");

    @EnumValue
    @JsonValue
    private final Boolean code;

    private final String description;

    EntityDeletedEnum(Boolean code, String description) {
        this.code = code;
        this.description = description;
    }

    public Boolean getCode() {
        return code;
    }

    @JsonCreator
    public static EntityDeletedEnum getByCode(Boolean code) {
        for (EntityDeletedEnum enumItem : EntityDeletedEnum.values()) {
            if (enumItem.code.equals(code)) {
                return enumItem;
            }
        }

        return null;
    }

}
