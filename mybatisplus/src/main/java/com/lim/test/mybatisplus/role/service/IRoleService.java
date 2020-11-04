package com.lim.test.mybatisplus.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lim.test.mybatisplus.role.model.dto.RoleSaveDto;
import com.lim.test.mybatisplus.role.model.entity.Role;

import java.util.List;

/**
 * @author lim
 * @since 2020/2/17
 */
public interface IRoleService extends IService<Role> {

    /**
     * 查询所有角色
     * @return List<Role>
     */
    List<Role> listAll();


    /**
     * 新增角色
     * @param roleSaveDto 角色信息
     * @return 影响的记录条数
     */
    Integer insert(RoleSaveDto roleSaveDto);

    /**
     * 删除角色
     * @param id 角色id
     * @return 影响的记录条数
     */
    Integer delete(Long id);

}
