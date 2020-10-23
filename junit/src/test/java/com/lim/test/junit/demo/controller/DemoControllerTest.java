package com.lim.test.junit.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lim.test.JunitApplication;
import com.lim.test.junit.demo.vo.User;
import com.lim.test.tools.commonresponse.response.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * controller 单元测试
 *
 * @author Lim
 * @date 2020/7/8
 */
@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {JunitApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("无返回参数")
    void getVoidTest() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/demo/void");
        MvcResult result = mockMvc.perform(req).andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    @DisplayName("返回String")
    void getString() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/demo/str");
        MvcResult result = mockMvc.perform(req).andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());
        String rs = result.getResponse().getContentAsString();
        log.info("result: {}", rs);
        Assertions.assertNotNull(rs);
    }

    @Test
    @DisplayName("返回javabean")
    void getUser() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/demo/user");
        MvcResult result = mockMvc.perform(req).andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());
        String rs = result.getResponse().getContentAsString();
        log.info("result: {}", rs);
        Assertions.assertNotNull(rs);

        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(rs, User.class);
        log.info("{}", user);
        Assertions.assertNotNull(rs);
    }

    @Test
    @DisplayName("返回统一封装结果")
    void getResult() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/demo/result");

        MvcResult result = mockMvc.perform(req).andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());
        result.getResponse().setCharacterEncoding("UTF-8");
        String rs = result.getResponse().getContentAsString();
        log.info("result: {}", rs);
        Assertions.assertNotNull(rs);

        // 使用fastjson实现
        ResponseBody<User> body1 = JSONObject.parseObject(rs,
                new com.alibaba.fastjson.TypeReference<ResponseBody<User>>() {});

        // 使用jackson实现
        ObjectMapper mapper = new ObjectMapper();
        ResponseBody<User> body = mapper.readValue(rs, new TypeReference<ResponseBody<User>>() {});
        log.info("ResponseBody：{}", body);
        Assertions.assertEquals(0, body.getErrorCode());
    }

    @Test
    @DisplayName("返回接收参数")
    void saveUser() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/demo/saveUser")
                .param("id", "2")
                .param("name", "test2")
                .param("deleted", "true");

        MvcResult result = mockMvc.perform(req).andReturn();
        Assertions.assertEquals(200, result.getResponse().getStatus());
        result.getResponse().setCharacterEncoding("UTF-8");
        String rs = result.getResponse().getContentAsString();
        log.info("result: {}", rs);
    }

}