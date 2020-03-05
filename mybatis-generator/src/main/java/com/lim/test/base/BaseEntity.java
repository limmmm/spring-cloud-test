package com.lim.test.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 数据库通用字段
 * @author Lim
 * @date 2020/3/5
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 创建者id
     */
    private String creatorId;

    /**
     * 创建者名称
     */
    private String creatorName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者id
     */
    private String updaterId;

    /**
     * 更新者名称
     */
    private String updaterName;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除标记{1:已删除, 0: 未删除}
     */
    private Boolean deleted;
}
