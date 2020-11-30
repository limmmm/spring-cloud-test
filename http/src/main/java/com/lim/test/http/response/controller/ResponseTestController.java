package com.lim.test.http.response.controller;

import com.lim.test.http.response.vo.ResponseTestVO;
import com.lim.test.common.response.response.ResponseBody;
import com.lim.test.common.response.response.Result;
import com.lim.test.common.response.response.ResultAssert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lim
 * @since 2020/3/8
 */
@Slf4j
@RestController
@RequestMapping(value = "/responsetest")
public class ResponseTestController {

    @GetMapping("/str")
    public ResponseBody<String> str(){
        return Result.success("str");
    }

    @GetMapping("/obj")
    public ResponseBody<ResponseTestVO> obj(){
        ResponseTestVO vo = new ResponseTestVO();
        vo.setId("123");
        vo.setName("name");
        return Result.success(vo);
    }

    @GetMapping("/err")
    public ResponseBody<ResponseTestVO> err(){
        log.info("error test start");
        ResultAssert.fail("中断测试");
        log.info("error test continue");

        ResponseTestVO vo = new ResponseTestVO();
        vo.setId("123");
        vo.setName("name");
        log.info("error test end");
        return Result.success(vo);
    }
}
