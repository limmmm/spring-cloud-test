package com.lim.test.mybatisplus.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lim.test.mybatisplus.user.model.dto.UserListDto;
import com.lim.test.mybatisplus.user.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Lim
 * @since 2020/2/11
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 分页
     * @param page 页面信息
     * @return 分页信息
     */
    @Select("select * from user")
    IPage<User> pageMapper(Page<User> page);

    /**
     * 分页
     * @param page 页面信息
     * @return 分页信息
     */
    IPage<User> pageXml(Page<User> page);


    /**
     * 条件查询
     * @param userListDto 查询条件
     * @return 记录
     */
    @Select("SELECT id,name,age,email FROM user WHERE (age = #{userListDto.age}) AND name LIKE concat('%', #{userListDto.name}, '%') AND  concat('%', #{userListDto.email})")
    List<User> listConditionMapper(@Param("userListDto") UserListDto userListDto);

    /**
     * 条件查询
     * @param userListDto 查询条件
     * @return 记录
     */
    List<User> listConditionXml(@Param("userListDto") UserListDto userListDto);

}
