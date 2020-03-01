package com.lim.test.swagger.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.lim.test.swagger.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Lim
 * @since 2020/3/1
 */
@Api(tags = {"用户相关接口"})
@RestController
@RequestMapping("/demo")
public class DemoController {

	@ApiOperation(value = "get测试接口")
	@GetMapping(value="hello")
    public String hello(@RequestParam Map<String, String> map) {
        return JSONObject.toJSONString(map);
  	}
	
	@ApiOperation(value="获取用户信息", notes="返回用户account/password信息")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", dataType = "User")
    @PostMapping(value="user")
    public String postUser(@RequestBody User user) {
        return user.getAccount() + "/" + user.getPassword();
    }
	
	@ApiOperation(value="获取用户信息",notes="tpye = 1 : 返回 account/password, 否则返回 account")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "path"),
			@ApiImplicitParam(name = "tag", value = "标记", required = false, dataType = "String", paramType = "path"),
			@ApiImplicitParam(name = "id", value = "id", required = false, dataType = "Long"),
			@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User"),
	})
	@PostMapping(value="getUser/{type}/{tag}")
	public String getUser(@PathVariable String type, @PathVariable String tag, Long id, @RequestBody User user){
		System.out.println(id);
		if("1".equals(type)){
			return user.getAccount() + "/" + user.getPassword();
		}
		return user.getAccount() + tag;
	}
}