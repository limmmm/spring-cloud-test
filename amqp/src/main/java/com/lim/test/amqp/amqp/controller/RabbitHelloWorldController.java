package com.lim.test.amqp.amqp.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 消息写入
 *
 * @author Lim
 * @since 2020/8/27
 */
@RestController
@RequestMapping(value = "/rabbit/helloworld")
public class RabbitHelloWorldController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public String helloWorld() {
        // 优先级为默认值0
        rabbitTemplate.convertAndSend("HelloWorldQueue", "HelloWorld0!" + LocalDateTime.now().toString());

        // 优先级为1
        rabbitTemplate.convertAndSend("HelloWorldQueue", "HelloWorld1!" + LocalDateTime.now().toString(), message -> {
            message.getMessageProperties().setPriority(1);
            return message;
        });

        // 优先级为2
        rabbitTemplate.convertAndSend("HelloWorldQueue", "HelloWorld2!" + LocalDateTime.now().toString(), message -> {
            message.getMessageProperties().setPriority(2);
            return message;
        });

        // 写入未设置优先级的队列，优先级为默认值0
        rabbitTemplate.convertAndSend("HelloQueue", "Hello!" + LocalDateTime.now().toString());

        // 写入不存在的队列，消息将会被丢弃
        rabbitTemplate.convertAndSend("WorldQueue", "World!" + LocalDateTime.now().toString());

        return "success";
    }
}
