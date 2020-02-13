package com.lim.test.mybatisplus.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lim.test.mybatisplus.user.mapper.UserMapper;
import com.lim.test.mybatisplus.user.model.dto.UserListDto;
import com.lim.test.mybatisplus.user.model.dto.UserPageDto;
import com.lim.test.mybatisplus.user.model.dto.UserSaveDto;
import com.lim.test.mybatisplus.user.model.entity.User;
import com.lim.test.mybatisplus.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lim
 * @date 2020/2/11
 */
@Service
@Primary
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listAll() {
        return userMapper.selectList(null);
    }

    @Override
    public List<User> listCondition(UserListDto userListDto) {
        // baseMapper 内置方法查询 - 对象
        User user = new User();
        BeanUtils.copyProperties(userListDto, user);
        List<User> rs1 = baseMapper.selectList(Wrappers.query(user));
        log.info("rs1: {}", rs1);

        // baseMapper 内置方法查询 - queryWrapper
        // null会参与匹配
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("age", userListDto.getAge());
        qw.like("name", userListDto.getName());
        qw.likeLeft("email", userListDto.getEmail());
        List<User> rs2 = baseMapper.selectList(qw);
        log.info("rs2: {}", rs2);

        // 使用baseMapper查询
        List<User> rs3 = baseMapper.listConditionMapper(userListDto);
        log.info("rs3: {}", rs3);

        // xml条件查询，对查询条件进行处理
        List<User> rs4 = baseMapper.listConditionXml(userListDto);
        log.info("rs4: {}", rs4);

        return rs1;
    }

    /**
     * 5中查询方式，推荐使用baseMapper内置方法查询
     */
    @Override
    public IPage<User> page(Page<User> page) {

        // 使用mapper内置方法查询
        IPage<User> page1 = userMapper.selectPage(page, null);

        // 从mapper中自定义查询
        IPage<User> page2 = userMapper.pageMapper(page);
        log.info("page2 {}", JSONObject.toJSONString(page2));

        // 从xml中查询
        IPage<User> page3 = userMapper.pageXml(page);
        log.info("page3 {}", JSONObject.toJSONString(page3));

        // 使用service查询
        IPage<User> page4 = super.page(page, null);
        log.info("page4 {}", JSONObject.toJSONString(page4));

        // 使用baseMapper查询
        IPage<User> page5 = baseMapper.selectPage(page, null);
        log.info("page5 {}", JSONObject.toJSONString(page5));

        return page1;
    }

    @Override
    public IPage<User> pageCondition(UserPageDto userPageDto) {
        return null;
    }

    @Override
    public User getById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public Integer insert(UserSaveDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return userMapper.insert(user);
    }

    @Override
    public Integer update(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public Integer delete(Long id) {
        return userMapper.deleteById(id);
    }
}
