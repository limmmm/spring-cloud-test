package com.lim.test.amqp.amqp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Ming
 * @date 2020/8/27
 */
@Configuration
public class RabbitHelloWorldConfiguration {

    @Bean
    public Queue helloWorldQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-max-priority", 10);
        return new Queue("HelloWorldQueue", false, false, false, args);
    }

    @Bean
    public Queue helloQueue() {
        return new Queue("HelloQueue", false, false, false);
    }
}
