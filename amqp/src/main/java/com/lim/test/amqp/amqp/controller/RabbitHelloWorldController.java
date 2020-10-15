package com.lim.test.amqp.amqp.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author Li Ming
 * @date 2020/8/27
 */
@RestController
@RequestMapping(value = "/rabbit/helloworld")
public class RabbitHelloWorldController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public void helloWorld() {
        rabbitTemplate.convertAndSend("HelloWorldQueue", "HelloWorld!" + LocalDateTime.now().toString());
        rabbitTemplate.convertAndSend("HelloWorldQueue", "HelloWorld1!" + LocalDateTime.now().toString(), message -> {
            message.getMessageProperties().setPriority(1);
            return message;
        });
        rabbitTemplate.convertAndSend("HelloWorldQueue", "HelloWorld2!" + LocalDateTime.now().toString(), message -> {
            message.getMessageProperties().setPriority(2);
            return message;
        });
        rabbitTemplate.convertAndSend("HelloQueue", "Hello!" + LocalDateTime.now().toString());
        rabbitTemplate.convertAndSend("WorldQueue", "World!" + LocalDateTime.now().toString());
    }
}
