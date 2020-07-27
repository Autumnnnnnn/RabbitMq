package com.example.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.SpringBootRabbitMqApplication;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringBootRabbitMqApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitmq {
    //注入rabbit Template
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //Topic 动态路由 订阅模式
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save","user.save 发送的消息");
        rabbitTemplate.convertAndSend("topics","order.save","order.save 发送的消息");
    }

    //route路由模式
    @Test
    public void testRoute(){
        rabbitTemplate.convertAndSend("direct","info","发送info的key的路由消息。。。");
        rabbitTemplate.convertAndSend("direct","warning","发送warning的key的路由消息。。。");
        rabbitTemplate.convertAndSend("direct","error","发送error的key的路由消息。。。");
    }

    //fanout 广播
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","fanout 的模式发送 的消息。。。");
    }

    @Test
    public void testWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","this is workQueue"+i);
        }
    }

    //hello world
    @Test
    public void testHello(){
        rabbitTemplate.convertAndSend("hello","helloWorld");
    }

}
