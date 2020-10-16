package com.lim.test.mybatisplus.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lim.test.mybatisplus.user.model.dto.UserListDto;
import com.lim.test.mybatisplus.user.model.dto.UserPageDto;
import com.lim.test.mybatisplus.user.model.dto.UserSaveDto;
import com.lim.test.mybatisplus.user.model.entity.User;
import com.lim.test.mybatisplus.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户
 * @author Lim
 * @date 2020/2/11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询所有
     * @return List<User>
     */
    @GetMapping("/list")
    public List<User> list() {
        return userService.listAll();
    }

    /**
     * 条件查询所有
     * @return List<User>
     */
    @GetMapping("/list/condition")
    public List<User> listCondition(UserListDto userListDto) {
        return userService.listCondition(userListDto);
    }

    /**
     * 分页查询
     * @return List<User>
     */
    @GetMapping("/page")
    public IPage<User> page() {
        Page<User> page = new Page<>();
        page.setSize(3);
        page.setCurrent(1);
        return userService.page(page);
    }

    /**
     * 条件分页查询
     * @return List<User>
     */
    @GetMapping("/page/condition")
    public IPage<User> pageCondition(UserPageDto pageDto) {
        return userService.pageCondition(pageDto);
    }

    /**
     * 查询单个
     * @param id 用户id
     * @return User
     */
    @GetMapping("/single")
    public User single(Integer id) {
        // WARN: 不建议使用这种方式，应使用mapper进行操作，便于事务统一处理，参考delete方法实现
        return userService.getById(id);
    }

    /**
     * 新增
     * @param userSaveDto 用户信息
     * @return 影响的记录条数
     */
    @PostMapping
    public Integer insert(@RequestBody UserSaveDto userSaveDto) {
        return userService.insert(userSaveDto);
    }

    /**
     * 修改
     * @param user 用户信息
     * @return 影响的记录条数
     */
    @PutMapping
    public Integer update(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     * 删除
     * @param id 用户id
     * @return 影响的记录条数
     */
    @DeleteMapping
    public Integer del(Long id) {
        return userService.delete(id);
    }

}
