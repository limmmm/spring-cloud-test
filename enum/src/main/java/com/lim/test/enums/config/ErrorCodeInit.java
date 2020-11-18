package com.lim.test.enums.config;

import com.lim.test.enums.demo.service.IDemoService;
import com.lim.test.enums.demo.util.ErrorCodeEnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 启动时初始化ErrorCode枚举值，可改为从数据库加载数据
 *
 * @author Lim
 * @since 2020-11-18
 */
@Component
public class ErrorCodeInit implements ApplicationRunner {

    @Autowired
    private IDemoService demoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        demoService.intiTest();
        ErrorCodeEnumUtil.showEnums();
    }

}
