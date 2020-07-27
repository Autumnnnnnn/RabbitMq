package com.example.demo.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
/**
 * 先声明队列再监听队列
 * 默认 持久化的durable=true、非独占、非自动删除 的队列
 */
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class helloCustomer {
    @RabbitHandler
    public void receive(String msg){
        System.out.println("msg : "+msg);
    }

}
