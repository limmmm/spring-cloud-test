package com.lim.test.enums.demo.service.impl;

import com.lim.test.enums.demo.service.IDemoService;
import com.lim.test.enums.demo.util.ErrorCodeEnumUtil;
import org.springframework.stereotype.Service;

/**
 * 测试service
 *
 * @author Lim
 * @since 2020-11-18
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Override
    public void intiTest() {
        ErrorCodeEnumUtil.add("TEST", -10003, "初始化测试", "init test");
        ErrorCodeEnumUtil.add("TEST2", -10004, "初始化测试2", "init test2");
    }

}
