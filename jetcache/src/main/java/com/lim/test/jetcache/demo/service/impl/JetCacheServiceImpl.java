package com.lim.test.jetcache.demo.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.lim.test.jetcache.demo.service.IJetCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * jetcache 操作
 *
 * @author lim
 * @since 2020/1/4
 */
@Slf4j
@Service
public class JetCacheServiceImpl implements IJetCacheService {

    /**
     * 自动刷新时入参不变，会重新执行方法中的计算逻辑以更新缓存数据
     * 若方法入参不变，输出结果也不变，此时刷新无意义，
     * 适用于参数不变，但结果不固定的场景
     */
    @Override
    @Cached(name="cacheTest:", key="#key", condition = "#value != '5'", expire = 60)
    @CacheRefresh(refresh = 30)
    public String post(String key, String value) {
        String rs = modify(value);
        log.info("添加缓存cacheTest，key,value : {}, {}", key, rs);
        return rs;
    }

    @Override
    @Cached(name="cacheTestDefalut:", key="#key", condition = "#value != '5'")
    public String defalutExpire(String key, String value) {
        String rs = modify(value);
        log.info("添加缓存cacheTestDefalut，key,value : {}, {}", key, rs);
        return rs;
    }

    /**
     * 若缓存同时开启了自动更新，下一次更新时仍会使用原来的入参重新计算，
     * 因此更新后的结果只在下一次自动刷新前(若已配置自动刷新)有效，参考{@link #post(String, String)}
     * 不适用于配置了自动更新，输入参数固定，输出结果也不变的场景，如本例，更新结果会被自动刷新覆盖
     * 适用于参数相同，但输出结果不固定的场景
     */
    @Override
    @CacheUpdate(name="cacheTest:", key="#key", value="#result")
    public String put(String key, String value) {
        String rs = modify(value);
        log.info("更新缓存，key,value : {}, {}", key, rs);
        return rs;
    }

    @Override
    @Cached(name="cacheTest:", key="#key", expire = 60)
    public String get(String key) {
        // 此方法当缓存中数据不为空时不会进入
        log.info("查询缓存，key: {}", key);
        return null;
    }

    /**
     * 若配置自动刷新，删除后还会恢复
     */
    @Override
    @CacheInvalidate(name="cacheTest:", key="#key")
    public String delete(String key) {
        log.info("删除缓存，key: {}", key);
        return key;
    }

    @Override
    @Cached(name="cacheTest:", key="#root.method.name", condition = "#value != '5'", expire = 10)
    @CacheRefresh(refresh = 10)
    public String postMethodName(String value) {
        String rs = value + Math.random();
        log.info("添加缓存cacheTest，value : {}", rs);
        return rs;
    }

    private String modify(String value) {
        if(value ==  null) {
            return null;
        }
        return value + value;
    }

}
