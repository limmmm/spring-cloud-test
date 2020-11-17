package com.lim.test.springcache.demo.controller;

import com.lim.test.springcache.demo.service.ISpringCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springcache 测试
 *
 * @author Lim
 * @since 2020/1/4
 */
@RestController
@RequestMapping(value = "/test")
public class SpringCacheController {

    private final ISpringCacheService springCacheService;

    @Autowired
    public SpringCacheController(ISpringCacheService springCacheService) {
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

    /**
     * 添加缓存数据, cacheName 为 test2，配置过期时间为2h
     *
     * @param key key
     * @param value value
     * @return value
     */
    @PostMapping("/cacheName2")
    public String cacheName2(String key, String value) {
        return springCacheService.cacheName2(key, value);
    }

    /**
     * 添加缓存数据, cacheName 为 test3，使用默认过期时间配置
     *
     * @param key key
     * @param value value
     * @return value
     */
    @PostMapping("/cacheName3")
    public String cacheName3(String key, String value) {
        return springCacheService.cacheName3(key, value);
    }

    /**
     * 添加缓存数据, cacheName 为 test1，使用自定义cacheManager
     *
     * @param key key
     * @param value value
     * @return value
     */
    @PostMapping("/cacheManager5m")
    public String cacheManager5m(String key, String value) {
        return springCacheService.cacheManager5m(key, value);
    }

    /**
     * 添加缓存数据, 未设置cacheName，使用默认过期时间配置
     *
     * @param key key
     * @param value value
     * @return value
     */
    @PostMapping("/defaultName")
    public String defaultName(String key, String value) {
        return springCacheService.noCacheName(key, value);
    }

    /**
     * 修改缓存数据
     * @param key key
     * @param value value
     * @return value
    */
    @PutMapping("/defaultName")
    public String put(String key, String value) {
        return springCacheService.put(key, value);
    }

    /**
     * 查询缓存数据
     * @param key key
     * @return value
    */
    @GetMapping("/defaultName")
    public String get(String key) {
        return springCacheService.get(key);
    }

    /**
     * 删除缓存数据
     * @param key key
     * @return key
    */
    @DeleteMapping("/defaultName")
    public String delete(String key) {
        return springCacheService.delete(key);
    }

}
