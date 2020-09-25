package com.lim.test.mybatisplus.role.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lim.test.mybatisplus.role.model.enums.RoleCodeEnum;
import com.lim.test.mybatisplus.role.model.enums.RoleTypeEnum;
import lombok.Data;

/**
 * 角色
 * @author Lim
 * @date 2020/2/17
 */
@Data
public class Role {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 编码
     */
    private RoleCodeEnum code;

    /**
     * 名称
     */
    private String name;

    /**
     * 删除标记
     */
    private Integer flag;

    /**
     * 类别
     */
    private RoleTypeEnum type;

}
