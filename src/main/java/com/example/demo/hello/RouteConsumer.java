package com.example.demo.hello;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "direct",type = "direct"),
                    key = {"info","error","warning"}
            )
    })
    public void reactReceive1(String s){
        System.out.println("receive 1 接收的消息:"+s);
    }
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "direct",type = "direct"),
                    key = {"error"}
            )
    })
    public void reactReceive2(String s){
        System.out.println("receive 2 接收的消息:"+s);
    }
}
