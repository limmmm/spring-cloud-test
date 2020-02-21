package com.lim.test.http.params.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * post参数接收测试
 * @author Lim
 * @date 2019/10/14
 */
@Slf4j
@RestController
@RequestMapping(value = "/posttest")
public class PostTestController {

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
     * 使用body formDate可接收参数
     */
    @PostMapping("/map3")
    public String map3(@RequestParam Map<String, String> map){
        log.info("teststr {}", map);
        return JSONObject.toJSONString(map);
    }
}
