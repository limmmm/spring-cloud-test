package com.lim.test.springtest.demo.controller;

import com.lim.test.springtest.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lim
 * @date 2020/1/11
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @GetMapping
    public String getTest() {
        return demoService.getStr();
    }

    /**
     * 无返回参数
     */
    @GetMapping("/void")
    public void getVoidTest() {
        System.out.println("/demo/void被调用");
    }
}
