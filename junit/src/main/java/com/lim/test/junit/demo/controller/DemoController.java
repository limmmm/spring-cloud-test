package com.lim.test.junit.demo.controller;

import com.lim.test.junit.demo.service.IDemoService;
import com.lim.test.junit.demo.vo.User;
import com.lim.test.common.response.response.ResponseBody;
import com.lim.test.common.response.response.Result;
import com.lim.test.common.response.response.ResultAssert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 *
 * @author Lim
 * @since  2020/01/11
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private IDemoService demoService;

    /**
     * 无返回参数
     */
    @GetMapping("/void")
    public void getVoidTest() {
        log.info("/demo/void被调用");
    }

    /**
     * 返回String
     */
    @GetMapping("/str")
    public String getString() {
        return demoService.getStr();
    }

    /**
     * 返回javabean
     */
    @GetMapping("/user")
    public User getUser() {
        ResultAssert.fail("failed");

        return new User(1, "test", true);
    }

    /**
     * 返回统一封装结果
     */
    @GetMapping("/result")
    public ResponseBody<User> getResult() {
        return Result.fail("aaaaaa");

//        return Result.success(new User(1, "test", true));
    }

    /**
     * 返回接收参数
     */
    @GetMapping("/saveUser")
    public String saveUser(User user) {
        return user.toString();
    }

}
