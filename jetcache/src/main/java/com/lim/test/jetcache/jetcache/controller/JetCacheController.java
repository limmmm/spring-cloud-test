package com.lim.test.jetcache.jetcache.controller;

import com.lim.test.jetcache.jetcache.service.IJetCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * jetCache 测试
 * @author Lim
 * @date 2020/1/4
 */
@RestController
@RequestMapping(value = "/demo/test")
public class JetCacheController {


    private final IJetCacheService jetCacheService;

    @Autowired
    public JetCacheController(IJetCacheService jetCacheService) {
        this.jetCacheService = jetCacheService;
    }

    /**
     * 添加缓存数据
     * @param key key
     * @param value value
     * @return value
    */
    @PostMapping
    public String post(String key, String value) {

        return jetCacheService.post(key, value);
    }

    /**
     * 添加缓存数据
     * @param key key
     * @param value value
     * @return value
     */
    @PostMapping("/postMethodName")
    public String postMethodName(String key, String value) {

        return jetCacheService.postMethodName(value);
    }

    /**
     * 添加缓存数据,默认过期时间
     * @param key key
     * @param value value
     * @return value
     */
    @PostMapping("defalutExpire")
    public String defalutExpire(String key, String value) {

        return jetCacheService.defalutExpire(key, value);
    }

    /**
     * 修改缓存数据
     * @param key key
     * @param value value
     * @return value
    */
    @PutMapping
    public String put(String key, String value) {

        return jetCacheService.put(key, value);
    }

    /**
     * 查询缓存数据
     * @param key key
     * @return value
    */
    @GetMapping
    public String get(String key) {

        return jetCacheService.get(key);
    }

    /**
     * 删除缓存数据
     * @param key key
     * @return key
    */
    @DeleteMapping
    public String delete(String key) {

        return jetCacheService.delete(key);
    }

}
