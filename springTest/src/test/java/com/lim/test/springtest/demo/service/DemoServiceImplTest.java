package com.lim.test.springtest.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * service 测试
 * @author Lim
 * @date 2020/7/9
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class DemoServiceImplTest {

    @Autowired
    private IDemoService demoService;

    @Test
    void getStr() {
        String str = demoService.getStr();
        log.info("demoService.getStr() 测试结果：{}", str);
        Assertions.assertNotNull(str, "demoService.getStr() 调用错误");
    }
}