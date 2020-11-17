package com.lim.test.activiti.demo.service.impl;

import com.lim.test.activiti.demo.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author Lim
 * @since 2020/3/4
 */
@Slf4j
@Service
@Primary
public class DemoServiceImpl implements IDemoService {

    @Override
    public void test() {
        log.info("test finished");
    }

}
