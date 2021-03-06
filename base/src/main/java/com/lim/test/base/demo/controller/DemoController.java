package com.lim.test.base.demo.controller;

import com.lim.test.common.response.response.ResponseBody;
import com.lim.test.common.response.response.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试实例controller
 *
 * @author Lim
 * @since 2020/1/11
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    @GetMapping
    public ResponseBody<String> getTest() {
        return Result.success("getTest");
    }

}
