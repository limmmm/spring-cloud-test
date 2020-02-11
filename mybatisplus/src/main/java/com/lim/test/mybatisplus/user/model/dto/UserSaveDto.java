package com.lim.test.mybatisplus.user.model.dto;

import lombok.Data;

/**
 * @author Lim
 * @date 2020/2/11
 */
@Data
public class UserSaveDto {
    private String name;
    private Integer age;
    private String email;
}
