package com.lim.test.mybatisplus.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lim.test.mybatisplus.user.model.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author Lim
 * @date 2020/2/11
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 分页
     * @param page 页面信息
     * @return 分页信息
     */
    @Select("select * from user")
    IPage<User> page(Page<User> page);

    /**
     * 分页
     * @param page 页面信息
     * @return 分页信息
     */
    IPage<User> pageXml(Page<User> page);
}
