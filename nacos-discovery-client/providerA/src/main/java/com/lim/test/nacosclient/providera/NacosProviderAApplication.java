package com.lim.test.nacosclient.providera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * nacos 服务A
 *
 * @author Lim
 * @since 2020/1/11
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderAApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderAApplication.class, args);
    }

}
