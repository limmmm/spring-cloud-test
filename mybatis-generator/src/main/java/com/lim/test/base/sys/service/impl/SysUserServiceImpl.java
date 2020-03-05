package com.lim.test.base.sys.service.impl;

import com.lim.test.base.sys.entity.SysUser;
import com.lim.test.base.sys.mapper.SysUserMapper;
import com.lim.test.base.sys.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author lim
 * @since 2020-03-05
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
