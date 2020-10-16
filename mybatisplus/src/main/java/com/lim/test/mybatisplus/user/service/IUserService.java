package com.lim.test.mybatisplus.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lim.test.mybatisplus.user.model.dto.UserListDto;
import com.lim.test.mybatisplus.user.model.dto.UserPageDto;
import com.lim.test.mybatisplus.user.model.dto.UserSaveDto;
import com.lim.test.mybatisplus.user.model.entity.User;

import java.util.List;

/**
 * @author Lim
 * @date 2020/2/11
 */
public interface IUserService extends IService<User> {

    /**
     * 查询所有用户
     * @return List<User>
     */
    List<User> listAll();

    /**
     * 查询所有用户
     * @param userListDto 查询条件
     * @return List<User>
     */
    List<User> listCondition(UserListDto userListDto);

    /**
     * 分页查询
     * @param page 页面设置
     * @return 页数据
     */
    IPage<User> page(Page<User> page);

    /**
     * 条件分页查询
     * @param userPageDto 查询条件
     * @return 页数据
     */
    IPage<User> pageCondition(UserPageDto userPageDto);

    /**
     * 根据id查用户详情
     * @param id 用户id
     * @return User
     */
    User getById(Long id);

    /**
     * 新增用户
     * @param user 用户信息
     * @return 影响的记录条数
     */
    Integer insert(UserSaveDto user);

    /**
     * 更新用户信息
     * @param user User
     * @return 影响的记录条数
     */
    Integer update(User user);

    /**
     * 删除用户
     * @param id 用户id
     * @return 影响的记录条数
     */
    Integer delete(Long id);
}
