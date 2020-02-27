package com.lim.test.base.sys.service.impl;

import com.lim.test.base.sys.entity.User;
import com.lim.test.base.sys.mapper.UserMapper;
import com.lim.test.base.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lim
 * @since 2020-02-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
