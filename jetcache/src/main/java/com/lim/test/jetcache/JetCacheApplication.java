package com.lim.test.jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * jetcache 测试
 *
 * @author Lim
 * @since 2020/1/4
 */
@SpringBootApplication
@EnableMethodCache(basePackages = "com.lim.test.jetcache")
@EnableCreateCacheAnnotation
public class JetCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetCacheApplication.class, args);
    }

}
