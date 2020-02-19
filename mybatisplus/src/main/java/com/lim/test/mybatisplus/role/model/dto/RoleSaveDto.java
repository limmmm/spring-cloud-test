package com.lim.test.mybatisplus.role.model.dto;

import com.lim.test.mybatisplus.role.model.enums.RoleCodeEnum;
import com.lim.test.mybatisplus.role.model.enums.RoleTypeEnum;
import lombok.Data;

/**
 * @author Lim
 * @date 2020/2/17
 */
@Data
public class RoleSaveDto {


    /**
     * 编码
     */
    private RoleCodeEnum code;

    /**
     * 名称
     */
    private String name;

    /**
     * 类别
     */
    private RoleTypeEnum type;

}
