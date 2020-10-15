package com.lim.test.base.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lim
 * @date 2020/1/11
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    @GetMapping
    public String getTest() {
        return "getTest";
    }
}
