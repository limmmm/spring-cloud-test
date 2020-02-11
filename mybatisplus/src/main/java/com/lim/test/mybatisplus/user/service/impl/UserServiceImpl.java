package com.lim.test.mybatisplus.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lim.test.mybatisplus.user.mapper.UserMapper;
import com.lim.test.mybatisplus.user.model.dto.UserSaveDto;
import com.lim.test.mybatisplus.user.model.entity.User;
import com.lim.test.mybatisplus.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.List;

/**
 * @author Lim
 * @date 2020/2/11
 */
@Service
@Primary
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listAll() {
        return userMapper.selectList(null);
    }

    @Override
    public IPage<User> page(Page<User> page) {

        IPage<User> page1 = userMapper.selectPage(page, null);

        // 从mapper中查询
        IPage<User> page2 = userMapper.page(page);
        log.info("page2 {}", JSONObject.toJSONString(page2));

        // 从xml中查询
        IPage<User> page3 = userMapper.pageXml(page);
        log.info("page3 {}", JSONObject.toJSONString(page3));

        return page1;
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
