package com.lim.test.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "主键")
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "创建者id")
    private String creatorId;

    @ApiModelProperty(value = "创建者名称")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新者id")
    private String updaterId;

    @ApiModelProperty(value = "更新者名称")
    private String updaterName;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "删除标记{1:已删除, 0: 未删除}")
    private Boolean deleted;

}
