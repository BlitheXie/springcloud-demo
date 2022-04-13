package net.blithe.comsumer.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutListener {

    @RabbitListener(queues = "fanout.queue1")
    public void listenerFanoutQueue1(String msg){
        System.out.println("消费者 接收到 fanout queue1 的消息: 【 "+ msg +"】");
    }


    @RabbitListener(queues = "fanout.queue2")
    public void listenerFanoutQueue2(String msg){
        System.out.println("消费者 接收到 fanout queue2 的消息: 【 "+ msg +"】");
    }


}
