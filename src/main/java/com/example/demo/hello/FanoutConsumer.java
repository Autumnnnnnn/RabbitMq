package com.example.demo.hello;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,//不指定名称，则创建临时列
            exchange =@Exchange(value = "logs",type = "fanout") //绑定交换机
    ))
    public void receive1(String msg){
        System.out.println("receive1 接收的消息："+msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,//不指定名称，则创建临时列
            exchange =@Exchange(value = "logs",type = "fanout") //绑定交换机
    ))
    public void receive2(String msg){
        System.out.println("receive2 接收的消息："+msg);
    }
}
