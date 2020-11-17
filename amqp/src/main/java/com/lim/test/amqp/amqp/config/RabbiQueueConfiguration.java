package com.lim.test.amqp.amqp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置队列名称
 *
 * @author Lim
 * @since 2020/8/27
 */
@Configuration
public class RabbiQueueConfiguration {

    /**
     * 该队列可设置10个优先级
     */
    @Bean
    public Queue helloWorldQueue() {
        Map<String, Object> args = new HashMap<>(16);
        args.put("x-max-priority", 10);
        return new Queue("HelloWorldQueue", false, false, false, args);
    }

    /**
     * 队列无优先级
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("HelloQueue", false, false, false);
    }

}
