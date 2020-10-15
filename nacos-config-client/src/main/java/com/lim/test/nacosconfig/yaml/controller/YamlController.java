package com.lim.test.nacosconfig.yaml.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lim
 * @date 2020/1/11
 */
@RestController
@RequestMapping("/test")
@RefreshScope
public class YamlController {

//    @Value("${spring.application}")
    private String application;

    @Value("${spring.datasource.url}")
    private String url;

//    @Value("${user.name}")
//    private String name;

    @GetMapping
    public String getTest() {
        return application + url;
    }

}
