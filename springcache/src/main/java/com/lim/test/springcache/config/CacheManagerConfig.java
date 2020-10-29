package com.lim.test.springcache.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

/**
 * cacheManager 配置
 *
 * @author lim
 * @date 2020/10/29
 */
@Configuration
@EnableCaching
public class CacheManagerConfig {

    /**
     * 重写默认的 cacheManager
     * 设置有效期
     */
    @Bean
    @Primary
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config30m = instanceConfig(1800L);
        RedisCacheConfiguration config1h = instanceConfig(3600L);
        RedisCacheConfiguration config2h = instanceConfig(7200L);
        return RedisCacheManager.builder(connectionFactory)
                // 默认有效期为30分钟
                .cacheDefaults(config30m)
                // 根据cacheName设置有效期
                .withCacheConfiguration("test1", config1h)
                .withCacheConfiguration("test2", config2h)
                .transactionAware()
                .build();
    }

    /**
     * 自定义 cacheManager 有效期5分钟
     * 设置有效期
     */
    @Bean
    public RedisCacheManager cacheManager5m(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config5m = instanceConfig(300L);
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config5m)
                .transactionAware()
                .build();
    }

    /**
     * 根据有效期生成redis cache manager 配置
     * @param ttl 有效期（秒）
     */
    private RedisCacheConfiguration instanceConfig(Long ttl) {

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
        // 去掉各种@JsonSerialize注解的解析
        objectMapper.configure(MapperFeature.USE_ANNOTATIONS, false);
        // 只针对非空的值进行序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 将类型序列化到属性json字符串中
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(ttl))
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer));

    }

}
