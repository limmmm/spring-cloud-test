package com.lim.test.lettuce.test.controller;

import com.lim.test.lettuce.test.entity.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * lettuce 操作redis 测试
 *
 * @author Lim
 * @since 2020/03/06
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * redis操作
     */
    @GetMapping
    public void ops() {
        // Integer 操作测试
        intOps();

        // String 操作测试
        strOps();

        // javaBean 操作测试
        javaBeanOps();

        // List 操作测试
        listOps();
    }

    /**
     * int 类型数据操作
     */
    private void intOps() {
        String key = "intObj";

        // 保存
        Integer value = 1;
        redisTemplate.opsForValue().set(key, value);

        // 读取
        Integer returnValue = (Integer) redisTemplate.opsForValue().get(key);
        log.info("intOps. key:{}, returnValue: {}", key, returnValue);
    }

    /**
     * String 类型数据操作
     */
    private void strOps() {
        String key = "strObj";

        // 保存
        String value = "test string";
        redisTemplate.opsForValue().set(key, value);

        // 读取
        String returnValue = (String) redisTemplate.opsForValue().get(key);
        log.info("strOps. key:{}, returnValue: {}", key, returnValue);
    }

    /**
     * javabean 操作
     */
    private void javaBeanOps() {
        String key = "javaBean";

        // 保存
        Test test = new Test(1, "name", 1);
        redisTemplate.opsForValue().set(key, test);

        // 读取
        Test returnValue = (Test) redisTemplate.opsForValue().get(key);
        log.info("javaBeanOps. key:{}, returnValue: {}", key, returnValue);
    }

    /**
     * list 操作
     */
    private void listOps() {
        String key = "listObj";

        // 保存
        Test test1 = new Test(1, "nameA", 1);
        Test test2 = new Test(2, "nameB", 2);
        Test test3 = new Test(3, "nameC", 3);
        Test test4 = new Test(4, "nameD", 4);

        redisTemplate.opsForList().rightPush(key, test1);
        redisTemplate.opsForList().rightPush(key, test2);
        redisTemplate.opsForList().rightPush(key, test3);
        redisTemplate.opsForList().rightPush(key, test4);

        // 读取
        List<Test> returnValue = redisTemplate.opsForList().range(key, 0, -1);
        log.info("listOps. key:{}, returnValue: {}", key, returnValue);
    }

}
