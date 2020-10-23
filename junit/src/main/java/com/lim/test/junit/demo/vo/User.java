package com.lim.test.junit.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 测试用户返回结果
 *
 * @author lim
 * @since 2020-01-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String name;

    private Boolean deleted;

}
