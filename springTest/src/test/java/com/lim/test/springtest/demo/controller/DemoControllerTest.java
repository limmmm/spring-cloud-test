package com.lim.test.springtest.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * controller 单元测试
 * @author Lim
 * @date 2020/7/8
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class DemoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTest() {
        String rs = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/springTest/demo", String.class);
        log.info("/springTest/demo 调用结果：{}", rs);
        Assertions.assertNotNull(rs, "接口异常");
    }

    /**
     * 无返回值接口测试，返回结果为null
     */
    @Test
    void getTestVoid() {
        String rs = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/springTest/demo/void", String.class);
        log.info("/springTest/demo 调用结果：{}", rs);
    }

}