package com.lim.test.mybatisplus.role.controller;

import com.lim.test.mybatisplus.role.model.dto.RoleSaveDto;
import com.lim.test.mybatisplus.role.model.entity.Role;
import com.lim.test.mybatisplus.role.service.IRoleService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色
 * 枚举功能测试
 *
 * @author lim
 * @since 2020/2/17
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
     * WARN: 若code、type所传参数值不在提供的范围内，则请求会直接报错，不会进入controller
     * WARN: 枚举类型参数接收需为string类型，若为int类型，则会根据ordinary进行匹配从而导致匹配错误
     *     请求中type的值若为数字1，则将匹配到TYPE2，若未字符串1，则将匹配到TYPE1
     *
     * @param roleSaveDto 机构信息
     * @return 影响的记录条数
     */
    @PostMapping
    public Integer insert(@RequestBody RoleSaveDto roleSaveDto) {
        return roleService.insert(roleSaveDto);
    }

    /**
     * 删除
     * WARN：逻辑删除,在application.yml中进行配置
     * @param id 机构id
     * @return 影响的记录条数
     */
    @DeleteMapping
    public Integer del(Long id) {
        return roleService.delete(id);
    }

}
