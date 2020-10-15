package com.lim.test.lettuce.test.entity;

import lombok.Data;

/**
 * @author Li Ming
 * @date 2020/9/29
 */
@Data
public class Test {

    private Integer id;

    /**
     * '姓名'
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;
}
