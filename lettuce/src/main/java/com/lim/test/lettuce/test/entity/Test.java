package com.lim.test.lettuce.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 测试java对象
 *
 * @author Li Ming
 * @since 2020/9/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {

    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;
}
