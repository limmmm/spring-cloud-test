package com.lim.test.http.params.controller;

import com.lim.test.http.params.controller.model.UserInfo;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * request 请求参数传递测试
 *
 * @author Li Ming
 * @since 2020/7/22
 */
@RestController
@RequestMapping("/request")
public class RequestController {

    /**
     * url传参
     * 适用于所有请求方式
     * 参数拼接在url后面，形如url?id=XXX&name=XXX
     */
    @RequestMapping(value = "/url", method =
            {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public String mapping(String id, String name) {
        return String.format("params: id: %s, name: %s", id, name);
    }

    /**
     * url传参，传输与接收的参数名称不同
     * 适用于所有请求方式
     * 参数拼接在url后面，形如url?userId=XXX&userName=XXX
     */
    @RequestMapping(value = "/url", method =
            {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public String requestParam(@RequestParam("userId") String id, @RequestParam("userName") String name) {
        return String.format("params: id: %s, name: %s", id, name);
    }

    /**
     * url路径传参
     * 适用于所有请求方式
     * 参数写在url路径中，形如/pathVariable/{userId}/{userName}
     * 注：传输的参数名可与接收的参数名不同
     */
    @RequestMapping(value = "/pathVariable/{userId}/{userName}", method =
            {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public String pathVariable(@PathVariable("userId") String id, @PathVariable("userName") String name) {
        return String.format("params: id: %s, name: %s", id, name);
    }

    /**
     * request body payload传参
     * 适用于POST、PUT请求
     * 参数写在request body中
     * Content-Type: application/json
     */
    @RequestMapping(value = "/requestBody", method = {RequestMethod.POST, RequestMethod.PUT})
    public String requestBody(@RequestBody Map<String, String> params) {
        return String.format("params: %s", params.toString());
    }

    /**
     * request body x-www-form-urlencoded传参
     * 适用于POST x-www-form-urlencoded请求
     * 参数写在request body中
     * Content-Type: application/x-www-form-urlencoded
     */
    @RequestMapping(value = "/requestBodyForm", method = {RequestMethod.POST, RequestMethod.PUT})
    @PostMapping("/requestBodyForm")
    public String requestBodyForm(@RequestParam Map<String, String> params) {
        return String.format("params: %s", params.toString());
    }

    /**
     * request 对象传参
     * 根据实际情况使用request对象获取请求参数
     */
    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        // 获取url传递的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, String> params = new HashMap<>();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            params.put(entry.getKey(), Arrays.toString(entry.getValue()));
        }

        // 获取body中的参数
        StringBuilder body = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String str;
            while ((str = reader.readLine()) != null) {
                body.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.format("params: %s, body: %s", params.toString(), body.toString());
    }

    /**
     * 保存文件
     * 采用post form-data形式
     * 无额外参数，userInfo可去掉
     */
    @PostMapping("/file")
    public String file(HttpServletRequest request, @RequestParam("file") MultipartFile file, UserInfo userInfo) {
        // 文件为空或文件名为空则说明文件接收失败
        if (file == null || StringUtils.isEmpty(file.getOriginalFilename())) {
            return "file not exist";
        }
        return String.format("file: %s, userInfo: %s", file.getOriginalFilename(), userInfo);
    }

}
