package com.lim.test.mybatisplus.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lim.test.mybatisplus.role.mapper.RoleMapper;
import com.lim.test.mybatisplus.role.model.dto.RoleSaveDto;
import com.lim.test.mybatisplus.role.model.entity.Role;
import com.lim.test.mybatisplus.role.model.enums.RoleCodeEnum;
import com.lim.test.mybatisplus.role.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lim
 * @since 2020/2/17
 */
@Service
@Primary
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<Role> listAll() {
        List<Role> roleList = baseMapper.selectList(null);
        for (Role role : roleList) {
            if(RoleCodeEnum.SUPER_ADMIN.equals(role.getCode())) {
                log.info("枚举匹配测试 {}", role);
            }
        }
        return baseMapper.selectList(null);
    }

    @Override
    public Integer insert(RoleSaveDto roleSaveDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleSaveDto, role);
        role.setFlag(1);
        return baseMapper.insert(role);
    }

    @Override
    public Integer delete(Long id) {
        return baseMapper.deleteById(id);
    }
}
