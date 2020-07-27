package com.example.demo.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nuisance
 * @date 2020/7/26 8:04
 */
@Component
public class receiveEmail {

    @RabbitListener(queuesToDeclare = @Queue(value = "sendEmail"))
    public void receiveE(Map map){
        System.out.println(map.get("email"));
        System.out.println(map.get("name"));
    }
}
