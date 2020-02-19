package com.lim.test.mybatisplus.role.model.dto;

import lombok.Data;

/**
 * @author Lim
 * @date 2020/2/17
 */
@Data
public class RoleSaveDto {


    /**
     * '姓名'
     */
    private String code;

    /**
     * '姓名'
     */
    private String name;

    /**
     * 类别
     */
    private Integer type;

}
