package com.lim.test.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AMQP(Rabbit MQ) 测试
 *
 * @author Lim
 * @since 2020/1/4
 */
@SpringBootApplication
public class AmpqApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmpqApplication.class, args);
    }

}
