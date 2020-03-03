package com.lim.test.activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Lim
 * @date 2020/3/3
 * WARN: 注意此类SecurityAutoConfiguration来源于activiti
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.lim.test.activiti")
public class TestActivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestActivityApplication.class, args);
    }

}
