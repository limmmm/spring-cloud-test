package com.lim.test.activiti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * activiti 测试
 *
 * @author lim
 * @since 2020/3/3
 * WARN: 注意此类SecurityAutoConfiguration来源于activiti
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.lim.test.activiti")
public class ActivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivityApplication.class, args);
    }

}
