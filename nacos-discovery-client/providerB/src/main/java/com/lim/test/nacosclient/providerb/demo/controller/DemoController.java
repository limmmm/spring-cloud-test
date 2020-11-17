package com.lim.test.nacosclient.providerb.demo.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lim
 * @since 2020/1/11
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    @NacosInjected
    private NamingService namingService;

    /**
     * 根据服务名获取所有实例信息
     */
    @GetMapping("/instance")
    public List<Instance> get(String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

    @GetMapping
    public String getTest() {
        return "serviceB getTest";
    }

}
