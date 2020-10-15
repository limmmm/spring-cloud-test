package com.lim.test.amqp.amqp.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Li Ming
 * @date 2020/8/27
 */
@Component
@RabbitListener(queues = {"HelloWorldQueue", "HelloQueue"})
@Slf4j
public class RabbitHelloWorldListener {

    @RabbitHandler
    public void receiveHelloWorld(String queueMessage) {
        log.info("Received message:{}", queueMessage);
    }
}
