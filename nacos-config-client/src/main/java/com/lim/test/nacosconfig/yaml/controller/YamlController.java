package com.lim.test.nacosconfig.yaml.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * nacos配置yaml
 * @RefreshScope开启自动更新
 *
 * @author Lim
 * @since 2020/1/11
 */
@RestController
@RequestMapping("/test")
@RefreshScope
public class YamlController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String name;

    @GetMapping
    public String getTest() {
        return String.format("applicationName: %s, url: %s, name: %s", applicationName, url, name);
    }

}
