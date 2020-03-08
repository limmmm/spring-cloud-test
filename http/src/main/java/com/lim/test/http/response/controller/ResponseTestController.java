package com.lim.test.http.response.controller;

import com.alibaba.fastjson.JSONObject;
import com.lim.test.http.response.vo.ResponseTestVO;
import com.lim.test.http.result.ResultVO;
import com.lim.test.http.result.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lim
 * @date 2020/3/8
 */
@Slf4j
@RestController
@RequestMapping(value = "/responsetest")
public class ResponseTestController {

    @GetMapping("/str")
    public ResultVO<String> str(){
        return ResultVOUtil.success("str");
    }

    @GetMapping("/obj")
    public ResultVO<ResponseTestVO> obj(){
        ResponseTestVO vo = new ResponseTestVO();
        vo.setId("123");
        vo.setName("name");
        return ResultVOUtil.success(vo);
    }
}
