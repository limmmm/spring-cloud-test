package com.baomidou.ant.sys.service.impl;

import com.baomidou.ant.sys.entity.User;
import com.baomidou.ant.sys.mapper.UserMapper;
import com.baomidou.ant.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lim
 * @since 2020-02-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
