package com.lim.test.tools.commonmybatis.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lim.test.tools.commonmybatis.enums.EntityDeletedEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 通用实体类字段
 *
 * @author lim
 * @since 2020-02-21
 */
@Data
public class BaseEntity {

    /** 主键 */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /** 创建者id */
    private String creatorId;

    /** 创建者名称 */
    private String creatorName;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 更新者id */
    private Long updaterId;

    /** 更新者名称 */
    private String updaterName;

    /** 更新时间 */
    private LocalDateTime updateTime;

    /** 是否逻辑删除 */
    private EntityDeletedEnum deleted;

}
