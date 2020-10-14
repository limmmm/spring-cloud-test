package com.lim.test.springtest.demo.service.impl;

import com.lim.test.springtest.demo.service.IDemoService;
import org.springframework.stereotype.Service;

/**
 * @author Lim
 * @date 2020/7/8
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Override
    public String getStr() {
        return "测试数据";
    }
}
