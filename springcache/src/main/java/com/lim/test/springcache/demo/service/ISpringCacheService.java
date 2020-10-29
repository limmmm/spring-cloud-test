package com.lim.test.springcache.demo.service;

import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * spring cache 操作
 *
 * @author lim
 * @since 2020/1/4
 */
public interface ISpringCacheService {

    /**
     * 添加缓存数据, cacheName 为 test1，配置过期时间为1h
     * {@link com.lim.test.springcache.config.CacheManagerConfig#cacheManager(RedisConnectionFactory)}
     *
     * @param key key
     * @param value value
     * @return value
     */
    String cacheName1(String key, String value);

    /**
     * 添加缓存数据, cacheName 为 test2，配置过期时间为2h
     * {@link com.lim.test.springcache.config.CacheManagerConfig#cacheManager(RedisConnectionFactory)}
     *
     * @param key key
     * @param value value
     * @return value
     */
    String cacheName2(String key, String value);

    /**
     * 添加缓存数据, cacheName 为 test3，使用默认过期时间配置
     * {@link com.lim.test.springcache.config.CacheManagerConfig#cacheManager(RedisConnectionFactory)}
     *
     * @param key key
     * @param value value
     * @return value
     */
    String cacheName3(String key, String value);

    /**
     * 添加缓存数据, cacheName 为 test1，使用自定义cacheManager
     * {@link com.lim.test.springcache.config.CacheManagerConfig#cacheManager5m(RedisConnectionFactory)}
     *
     * @param key key
     * @param value value
     * @return value
     */
    String cacheManager5m(String key, String value);

    /**
     * 添加缓存数据, 未设置cacheName，使用默认过期时间配置
     * {@link com.lim.test.springcache.config.CacheManagerConfig#cacheManager(RedisConnectionFactory)}
     *
     * @param key key
     * @param value value
     * @return value
     */
    String noCacheName(String key, String value);

    /**
     * 修改缓存数据
     * @param key key
     * @param value value
     * @return value
     */
    String put(String key, String value);

    /**
     * 查询缓存数据
     * @param key key
     * @return value
     */
    String get(String key);

    /**
     * 删除缓存数据
     * @param key key
     * @return key
     */
    String delete(String key);

}
