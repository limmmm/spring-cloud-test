package com.lim.test.junit.demo.service.impl;

import com.lim.test.junit.demo.service.IDemoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 测试service
 *
 * @author lim
 * @since 2020/7/8
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Override
    public String getStr() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

}
