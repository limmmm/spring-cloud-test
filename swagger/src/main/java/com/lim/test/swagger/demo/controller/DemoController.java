package com.lim.test.swagger.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.lim.test.swagger.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Lim
 * @since 2020/3/1
 */
@Slf4j
@Api(tags = {"用户相关接口"})
@RestController
@RequestMapping("/demo/")
public class DemoController {

    @ApiOperation(value = "get测试接口")
    @GetMapping(value="hello")
    public String hello(@RequestParam Map<String, String> map) {
        log.info("入参：{}", map);
        return JSONObject.toJSONString(map);
      }

    @ApiOperation(value="获取用户信息", notes="返回用户account/password信息")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", dataType = "User")
    @PostMapping(value="user")
    public String postUser(@RequestBody User user) {
        log.info("入参：{}", user);
        return user.getAccount() + "/" + user.getPassword();
    }

    /** defaultValue 设置无效 */
    @ApiOperation(value="获取用户信息",notes="tpye = type1 : 返回 account/password, 否则返回 account")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型", example = "type2", defaultValue = "type1", required = true,
                    dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "tag", value = "标记", example = "tagA", required = false,
                    dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "id", value = "主键", example = "789", required = false, dataType = "long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User"),
    })
    @PostMapping(value="getUser/{type}/{tag}")
    public String getUser(@PathVariable String type, @PathVariable String tag, Long id, @RequestBody User user){
        log.info("入参：type: {}, tag: {}, id: {}, user: {}", type, tag, id, user);
        if("type1".equals(type)){
            return user.getAccount() + "/" + user.getPassword();
        }
        return user.getAccount() + tag;
    }

}
