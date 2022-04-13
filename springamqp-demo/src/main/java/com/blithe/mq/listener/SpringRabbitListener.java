package com.blithe.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SpringRabbitListener {

    @RabbitListener(queues = "simple.name")
    public void listenSimpleQueue(String msg){
        System.out.println("spring amqp 消费者接受到的方法：" + msg);
    }

}
