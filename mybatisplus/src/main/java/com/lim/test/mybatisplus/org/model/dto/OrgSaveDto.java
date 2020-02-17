package com.lim.test.mybatisplus.org.model.dto;

import lombok.Data;

/**
 * @author Lim
 * @date 2020/2/17
 */
@Data
public class OrgSaveDto {
    /**
     * 名称
     */
    private String name;
    /**
     * 状态
     */
    private Integer status;
}
