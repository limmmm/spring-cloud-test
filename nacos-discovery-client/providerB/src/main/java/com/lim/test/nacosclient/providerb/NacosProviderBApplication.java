package com.lim.test.nacosclient.providerb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * nacos 服务B
 *
 * @author Lim
 * @since 2020/1/11
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderBApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderBApplication.class, args);
    }

}
