package com.tplink.cloud.parking.commonservice.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.tplink.cloud.parking.commonservice.enums.EntityDeletedEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 通用实体类字段
 * 车辆账户表
 *
 * @author liming
 * @since 2020-09-27
 */
@Data
public class BaseEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 创建人id
     */
    private Long createdUserId;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;

    /**
     * 更新人id
     */
    private Long updatedUserId;

    /**
     * 是否逻辑删除
     */
    private EntityDeletedEnum deleted;

}
