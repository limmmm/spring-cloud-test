package com.lim.test.springcache.demo.controller;

import com.lim.test.springcache.demo.service.ISpringCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springcache 测试
 * service注入到controller中也可正常使用
 *
 * @author lim
 * @since 2020/1/4
 */
@RestController
@RequestMapping(value = "/test2")
public class SpringCacheController2 {

    private final ISpringCacheService springCacheService;

    @Autowired
    public SpringCacheController2(ISpringCacheService springCacheService) {
        this.springCacheService = springCacheService;
    }

    /**
     * 添加缓存数据, cacheName 为 test1，配置过期时间为1h
     *
     * @param key key
     * @param value value
     * @return value
    */
    @PostMapping("/cacheName1")
    public String cacheName1(String key, String value) {
        return springCacheService.cacheName1(key, value);
    }

}
