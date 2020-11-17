package com.lim.test.amqp.amqp.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 队列监听
 * WARN: 消息被消费后即从消息队列中删除，测试时视情况关闭监听器
 *
 * @author Lim
 * @since 2020/8/27
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
