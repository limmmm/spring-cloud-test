package com.lim.test.springcache.demo.service.impl;

import com.lim.test.springcache.demo.service.ISpringCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * springcache 操作
 *
 * @author lim
 * @since 2020/1/4
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "cacheTest")
public class SpringCacheServiceImpl implements ISpringCacheService {

    @Override
    @Cacheable(cacheNames = "test1", key = "#key", unless = "#result eq null or #result eq ''")
    public String cacheName1(String key, String value) {
        String rs = modify(value);
        log.info("添加缓存cache, cacheName: test1, key: {}, value: {}", key, rs);
        return rs;
    }

    @Override
    @Cacheable(cacheNames = "test2", key = "#key", unless = "#result eq null or #result eq ''")
    public String cacheName2(String key, String value) {
        String rs = modify(value);
        log.info("添加缓存cache, cacheName: test2, key: {}, value: {}", key, rs);
        return rs;
    }

    @Override
    @Cacheable(cacheNames = "test3", key = "#key", unless = "#result eq null or #result eq ''")
    public String cacheName3(String key, String value) {
        String rs = modify(value);
        log.info("添加缓存cache, cacheName: test2, key: {}, value: {}", key, rs);
        return rs;
    }

    @Override
    @Cacheable(cacheNames = "test5m", key = "#key", unless = "#result eq null or #result eq ''",
            cacheManager = "cacheManager5m")
    public String cacheManager5m(String key, String value) {
        String rs = modify(value);
        log.info("添加缓存cache, cacheName: test, cacheManager: cacheManager5m, key: {}, value: {}", key, rs);
        return rs;
    }

    @Override
    @Cacheable(key = "#key", unless = "#result eq null or #result eq ''")
    public String noCacheName(String key, String value) {
        String rs = modify(value);
        log.info("添加缓存cache, 未设置cacheName, key: {}, value: {}", key, rs);
        return rs;
    }

    @Override
    @CachePut(key = "#key")
    public String put(String key, String value) {
        String rs = modify(value);
        log.info("更新缓存，key：{},value: {}", key, rs);
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
