package com.lim.test.lettuce.test.controller;

import com.lim.test.lettuce.test.entity.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author lim
 * @since 2020-03-06
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class SysUserController {

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping
    public void get() {
        Integer intObj = (Integer) redisTemplate.opsForValue().get("intObj");
        String strObj = (String) redisTemplate.opsForValue().get("strObj");
        Test obj = (Test) redisTemplate.opsForValue().get("obj");
        List<Test> objList = (List<Test>) redisTemplate.opsForList().range("list", 0, -1);

        log.info("{}, eq 1? {}", intObj, intObj == 1);
        log.info("{}, eq 'str value'? {}", strObj, "str value".equals(strObj));
        log.info("{}, Integer.id eq 1? {}", obj, obj.getId() == 1);
        log.info("{}, list size: {}", objList, objList.size());
    }

    @PostMapping
    public void save() {
        redisTemplate.opsForValue().set("intObj", 1);
        redisTemplate.opsForValue().set("strObj", "str value");

        Test test = new Test();
        test.setId(1);
        test.setName("name");
        test.setStatus(1);
        redisTemplate.opsForValue().set("obj", test);

        redisTemplate.opsForList().rightPush("list", test);
        redisTemplate.opsForList().rightPush("list", test);
        redisTemplate.opsForList().rightPush("list", test);
        redisTemplate.opsForList().rightPush("list", test);
    }
}
