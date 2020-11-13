package com.lim.test.nacosclient.customer.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * nacos 调用服务
 * 负载均衡
 * @author lim
 * @since 2020/1/11
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    private final RestTemplate restTemplate;

    @Autowired
    public DemoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 通过nacos调用其他服务，实现负载均衡，可搭配feign使用
     * WARN: 需要使用RestTemplate发起请求，否则会导无法识别服务，不经过nacos
     *      http://服务名/context-path/业务路径
     */
    @GetMapping
    public String getTest() {
        return restTemplate.getForObject("http://nacosProvider/nacosProvider/test", String.class);
    }

}
