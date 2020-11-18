package com.lim.test.enums.demo.controller;

import com.lim.test.enums.demo.util.ErrorCodeEnumUtil;
import com.lim.test.tools.commonresponse.response.ErrorCode;
import com.lim.test.tools.commonresponse.response.ResponseBody;
import com.lim.test.tools.commonresponse.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 枚举操作测试
 *
 * @author Lim
 * @since 2020-11-18
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class DemoController {

    /**
     * 打印并返回说有枚举类型
     */
    @GetMapping
    public ResponseBody<ErrorCode[]> getEnum() {

        ErrorCodeEnumUtil.showEnums();

        return Result.success(ErrorCode.values());
    }

    /**
     * 添加枚举类型
     */
    @PutMapping
    public ResponseBody<ErrorCode[]> updateEnum() {

        ErrorCodeEnumUtil.add("LOGIN_FAILED", -10000, "登录失败", "login failed");
        ErrorCodeEnumUtil.add("LOGIN_SUCCESS", -10001, "登录成功", "login success");

        return Result.success(ErrorCode.values());
    }

}
