package com.lim.test.mybatisplus.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
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
        // WARN: 直接使用对象生成wrapper，null将被忽略
        QueryWrapper<User> queryWrapper = Wrappers.query(user);
        List<User> rs1 = baseMapper.selectList(queryWrapper);
        log.info("rs1: {}", rs1);

        // baseMapper 内置方法查询 - queryWrapper
        // WARN: 使用带条件的条件构造方法，不带条件的话null也将参与参数匹配
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq(userListDto.getAge() != null, "age", userListDto.getAge());
        qw.like(StringUtils.isNotBlank(userListDto.getName()), "name", userListDto.getName());
        qw.likeLeft(StringUtils.isNotBlank(userListDto.getEmail()), "email", userListDto.getEmail());
        List<User> rs2 = baseMapper.selectList(qw);
        log.info("rs2: {}", rs2);

        // 使用baseMapper查询
        // WARN: 未处理非空问题
        List<User> rs3 = baseMapper.listConditionMapper(userListDto);
        log.info("rs3: {}", rs3);

        // xml条件查询，对查询条件进行处理
        List<User> rs4 = baseMapper.listConditionXml(userListDto);
        log.info("rs4: {}", rs4);

        // 使用lambda进行查询，通过构造方法传入条件
        List<User> rs5 = baseMapper.selectList(Wrappers.lambdaQuery(user));
        log.info("rs5: {}", rs5);

        // 使用lambda进行查询，后续构造条件
        LambdaQueryWrapper<User> lqw = Wrappers.lambdaQuery(User.class);
        lqw.eq(User::getName, userListDto.getName());
        lqw.eq(userListDto.getAge() != null, User::getAge, userListDto.getAge());
        lqw.eq(StringUtils.isNotBlank(userListDto.getEmail()), User::getEmail, userListDto.getEmail());
        List<User> rs6 = baseMapper.selectList(lqw);
        log.info("rs6: {}", rs6);

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

        // 使用mapper内置方法查询
        // 其他分页查询参考page，查询条件设置参考listCondition
        User user = new User();
        BeanUtils.copyProperties(userPageDto, user);
        IPage<User> page1 = baseMapper.selectPage(userPageDto, new QueryWrapper<>(user));

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
        // 根据id更新整个对象
        Integer rs = userMapper.updateById(user);

        // 使用wrapper更新整个对象，id不会更新
        UpdateWrapper<User> uw = new UpdateWrapper<>();
        uw.lambda().eq(User::getId, user.getId());
        // user.setId((long) 7); // 此处改变id无效，不更新id
        baseMapper.update(user, uw);

        // 使用wrapper更新
        uw = new UpdateWrapper<>();
        uw.set("name", user.getName()).set("age", user.getAge()).set("email", user.getEmail())
                .eq("id", user.getId());
        baseMapper.update(null, uw);

        // 使用wrapper lambda更新
        uw = new UpdateWrapper<>();
        uw.lambda().set(User::getName, user.getName()).set(User::getAge, user.getAge()).set(User::getEmail, user.getEmail())
                .eq(User::getId, user.getId());
        baseMapper.update(null, uw);

        // 省略根据mapper、xml更新

        return rs;
    }

    @Override
    public Integer delete(Long id) {
        return userMapper.deleteById(id);
    }
}
