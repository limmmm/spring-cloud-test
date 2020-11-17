package com.lim.test.mybatisplus.org.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author Lim
 * @since 2020/2/17
 */
@Data
public class Org {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 状态
     */
    @TableLogic
    private Integer status;

}
