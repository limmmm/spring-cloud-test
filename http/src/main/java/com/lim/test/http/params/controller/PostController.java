package com.lim.test.http.params.controller;

import com.alibaba.fastjson.JSONObject;
import com.lim.test.http.validate.module.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * post参数接收测试
 *
 * @author lim
 * @since 2019/10/14
 */
@Slf4j
@RestController
@RequestMapping(value = "/post")
public class PostController {

    /**
     * 500 参数不匹配
     * java.lang.IllegalArgumentException: argument type mismatch
     */
    @PostMapping("/json")
    public String josn(JSONObject json){
        log.info("teststr {}", json);
        return JSONObject.toJSONString(json);
    }

    /**
     * body raw json 可正常接收
     */
    @PostMapping("/json2")
    public String josn2(@RequestBody JSONObject json){
        log.info("teststr {}", json);
        return JSONObject.toJSONString(json);
    }

    /**
     * 接口不报错
     * 无法接收参数
     */
    @PostMapping("/map")
    public String map(Map<String, String> map){
        log.info("teststr {}", map);
        return JSONObject.toJSONString(map);
    }

    /**
     * 成功
     * body raw json 可正常接收
     */
    @PostMapping("/map2")
    public String map2(@RequestBody Map<String, String> map){
        log.info("teststr {}", map);
        return JSONObject.toJSONString(map);
    }

    /**
     * 成功
     * 使用params（url拼接）可以接收参数
     * 使用body formDate 可接收参数
     * 使用body x-www-form-urlencoded 可接收参数
     */
    @PostMapping("/map3")
    public String map3(@RequestParam Map<String, String> map){
        log.info("teststr {}", map);
        return JSONObject.toJSONString(map);
    }

    /**
     * 成功
     * 使用 @JsonFormat 将接收参数按指定格式转化为javabean
     *      WARN: 时间参数结束的注解与get方法不同
     * 使用 @JsonFormat 将时间转化为指定格式字符串
     */
    @PostMapping("/time")
    public UserDto time(@RequestBody UserDto userDto) {
        log.info("{}", userDto);
        return userDto;
    }
}
