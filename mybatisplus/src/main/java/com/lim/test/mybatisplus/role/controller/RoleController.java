package com.lim.test.mybatisplus.role.controller;

import com.lim.test.mybatisplus.role.model.dto.RoleSaveDto;
import com.lim.test.mybatisplus.role.model.entity.Role;
import com.lim.test.mybatisplus.role.service.IRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色-枚举
 * @author Lim
 * @date 2020/2/17
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }


    /**
     * 查询所有
     * @return List<User>
     */
    @GetMapping("/list")
    public List<Role> list() {
        return roleService.listAll();
    }

    /**
     * 新增
     * @param roleSaveDto 机构信息
     * @return 影响的记录条数
     */
    @PostMapping
    public Integer insert(@RequestBody RoleSaveDto roleSaveDto) {
        // WARN: 枚举类型参数接收需为string类型，若为int类型，则会根据ordinary进行匹配从而导致匹配错误
        // WARN: 枚举类中无法匹配则接口报错，不进入接口方法
        return roleService.insert(roleSaveDto);
    }

    /**
     * 删除
     * @param id 机构id
     * @return 影响的记录条数
     */
    @DeleteMapping
    public Integer del(String id) {
        return roleService.delete(id);
    }

}
