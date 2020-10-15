package com.lim.test.http.params.controller;

import com.alibaba.fastjson.JSONObject;
import com.lim.test.http.validate.module.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * get参数接收测试
 * @author Lim
 * @date 2019/10/14
 */
@Slf4j
@RestController
@RequestMapping(value = "/gettest")
public class GetTestController {

    /**
     * 500 参数类型不匹配
     * java.lang.IllegalArgumentException: argument type mismatch
     */
    @GetMapping("/json")
    public String josn(JSONObject json){
        log.info("teststr {}", json);
        return json.toJSONString();
    }

    /**
     * 500 参数类型不匹配
     * java.lang.IllegalArgumentException: argument type mismatch
     */
    @GetMapping("/json2")
    public String josn2(@RequestParam JSONObject json){
        log.info("teststr {}", json);
        return json.toJSONString();
    }

    /**
     * 接口不报错
     * 无法接收参数
     */
    @GetMapping("/map")
    public String map(Map<String, String> map){
        log.info("teststr {}", map);
        return JSONObject.toJSONString(map);
    }

    /**
     * 成功
     * 使用params（url拼接）可以接收参数
     * 使用body formDate可接收参数
     */
    @GetMapping("/map2")
    public String map2(@RequestParam Map<String, String> map){
        log.info("teststr {}", map);
        return JSONObject.toJSONString(map);
    }

    @GetMapping("/time")
    public UserDto time(UserDto userDto) {
        log.info("{}", userDto);
        return userDto;
    }
}
