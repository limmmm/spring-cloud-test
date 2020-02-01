package com.lim.test.springcache.springcache.service.impl;

import com.lim.test.springcache.springcache.service.ISpringCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Lim
 * @date 2020/1/4
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "cacheTest")
public class SpringCacheServiceImpl implements ISpringCacheService {

    @Override
    @Cacheable(key = "#key", unless = "#result eq null  or #result eq ''")
    public String post(String key, String value) {
        String rs = modify(value);
        log.info("添加缓存cacheTest，key,value : {}, {}", key, rs);
        return rs;
    }

    @Cacheable(key = "#key", unless = "#result eq null  or #result eq ''")
    public String defalutExpire(String key, String value) {
        String rs = modify(value);
        log.info("添加缓存cacheTestDefalut，key,value : {}, {}", key, rs);
        return rs;
    }

    @Override
    @CachePut(key = "#key")
    public String put(String key, String value) {
        String rs = modify(value);
        log.info("更新缓存，key,value : {}, {}", key, rs);
        return rs;
    }

    @Override
    @Cacheable(key = "#key")
    public String get(String key) {
        return null;
    }

    @Override
    @CacheEvict(key="#key")
    public String delete(String key) {
        log.info("删除缓存，key: {}", key);
        return key;
    }

    private String modify(String value) {
        if(value ==  null) {
            return null;
        }
        return value + value;
    }
}
