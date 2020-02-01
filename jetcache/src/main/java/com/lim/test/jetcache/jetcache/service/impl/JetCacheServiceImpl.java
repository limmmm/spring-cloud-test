package com.lim.test.jetcache.jetcache.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.lim.test.jetcache.jetcache.service.IJetCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Lim
 * @date 2020/1/4
 */
@Slf4j
@Service
public class JetCacheServiceImpl implements IJetCacheService {

    @Override
    @Cached(name="cacheTest", key="#key", condition = "#value != '5'", expire = 30)
    @CacheRefresh(refresh = 30)
    public String post(String key, String value) {
        String rs = modify(value);
        log.info("添加缓存cacheTest，key,value : {}, {}", key, rs);
        return rs;
    }

    @Cached(name="cacheTestDefalut", key="#key", condition = "#value != '5'")
    public String defalutExpire(String key, String value) {
        String rs = modify(value);
        log.info("添加缓存cacheTestDefalut，key,value : {}, {}", key, rs);
        return rs;
    }

    @Override
    @CacheUpdate(name="cacheTest", key="#key", value="#result")
    public String put(String key, String value) {
        String rs = modify(value);
        log.info("更新缓存，key,value : {}, {}", key, rs);
        return rs;
    }

    @Override
    @Cached(name="cacheTest", key="#key", expire = 60)
    public String get(String key) {

        return null;
    }

    @Override
    @CacheInvalidate(name="cacheTest", key="#key")
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
