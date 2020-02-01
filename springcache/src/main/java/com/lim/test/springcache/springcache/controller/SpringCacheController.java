package com.lim.test.springcache.springcache.controller;

import com.lim.test.springcache.springcache.service.ISpringCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * springcache 测试
 * @author Lim
 * @date 2020/1/4
 */
@RestController
@RequestMapping(value = "/demo/test")
public class SpringCacheController {


    private final ISpringCacheService springCacheService;

    @Autowired
    public SpringCacheController(ISpringCacheService springCacheService) {
        this.springCacheService = springCacheService;
    }

    /**
     * 添加缓存数据
     * @param key key
     * @param value value
     * @return value
    */
    @PostMapping
    public String post(String key, String value) {

        return springCacheService.post(key, value);
    }

    /**
     * 添加缓存数据,默认过期时间
     * @param key key
     * @param value value
     * @return value
     */
    @PostMapping("defalutExpire")
    public String defalutExpire(String key, String value) {

        return springCacheService.defalutExpire(key, value);
    }

    /**
     * 修改缓存数据
     * @param key key
     * @param value value
     * @return value
    */
    @PutMapping
    public String put(String key, String value) {

        return springCacheService.put(key, value);
    }

    /**
     * 查询缓存数据
     * @param key key
     * @return value
    */
    @GetMapping
    public String get(String key) {

        return springCacheService.get(key);
    }

    /**
     * 删除缓存数据
     * @param key key
     * @return key
    */
    @DeleteMapping
    public String delete(String key) {

        return springCacheService.delete(key);
    }

}
