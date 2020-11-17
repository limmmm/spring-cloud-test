package com.lim.test.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 基础springboot测试模块
 * 用于复制修改生成其他测试模块
 *
 * @author Lim
 * @since 2020/1/11
 */
@SpringBootApplication
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

}
