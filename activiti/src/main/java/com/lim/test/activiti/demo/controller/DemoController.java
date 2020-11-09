package com.lim.test.activiti.demo.controller;

import com.lim.test.activiti.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lim
 * @since 2020/1/11
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @GetMapping
    public String getTest() {
        demoService.test();
        return "getTest";
    }

}
