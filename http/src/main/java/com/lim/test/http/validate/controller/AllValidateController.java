package com.lim.test.http.validate.controller;

import com.alibaba.fastjson.JSONObject;
import com.lim.test.http.validate.module.dto.UserDto;
import com.lim.test.http.validate.module.group.NameGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * 所有方法开启参数校验
 * Validated 为spring标准 基于 Spring's JSR-303
 *  Valid 为 javax标准 基于 JSR-303
 * @author Lim
 * @date 2020/2/22
 */
@Validated
@Slf4j
@RestController
@RequestMapping(value = "/allvalidate")
public class AllValidateController {

    /**
     * 会触发校验
     */
    @GetMapping("/test1")
    public String test1(@NotBlank(message="name can't be blank") String name) {
        return "name : " + name;
    }

    /**
     * 不会触发校验
     */
    @GetMapping("/test2")
    public String test2(UserDto dto) {
        return JSONObject.toJSONString(dto);
    }

    /**
     * 会触发校验
     */
    @GetMapping("/test3")
    public String test3(@Validated UserDto dto) {
        return JSONObject.toJSONString(dto);
    }

    /**
     * 会触发校验
     */
    @GetMapping("/test4")
    public String test4(@Validated(NameGroup.class) UserDto dto) {
        return JSONObject.toJSONString(dto);
    }

}
