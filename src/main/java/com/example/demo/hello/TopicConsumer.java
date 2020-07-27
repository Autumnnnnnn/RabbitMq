package com.example.demo.hello;

import com.sun.jdi.event.StepEvent;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {

    @RabbitListener(bindings = {
        @QueueBinding(
                value = @Queue,
                exchange = @Exchange(type = "topic",name = "topics"),
                key = {"user.save","user.*"}
        )
    })
    public void receive1(String s){
        System.out.println("receive 接收的："+s);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(type = "topic",name = "topics"),
                    key = {"order.save","order.*"}
            )
    })
    public void receive2(String s){
        System.out.println("receive2 接收的："+s);
    }
}
