package com.lim.test.http.validate.controller;

import com.alibaba.fastjson.JSONObject;
import com.lim.test.http.validate.module.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * 所有方法开启参数校验
 * Validated 为spring标准 基于 Spring's JSR-303
 *  Valid 为 javax标准 基于 JSR-303
 * @author lim
 * @since 2020/2/22
 */
@Slf4j
@RestController
@RequestMapping(value = "/validate")
public class ValidateController {

    /**
     * 不会触发校验
     */
    @GetMapping("/test1")
    public String test1(@NotBlank(message="name can't be blank") String name) {
        return "name : " + name;
    }

    /**
     * 不会触发校验
     */
    @GetMapping("/test2")
    public String test2(@Validated @NotBlank(message="name can't be blank") String name) {
        return "name : " + name;
    }

    /**
     * 会触发校验
     */
    @GetMapping("/test3")
    public String test3(@Validated UserDto dto) {
        return JSONObject.toJSONString(dto);
    }

}
