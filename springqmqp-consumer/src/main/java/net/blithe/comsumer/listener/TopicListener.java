package net.blithe.comsumer.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topicQueue1"),
            exchange = @Exchange(name = "blithe.topic",type = ExchangeTypes.TOPIC),
            key = "#.news"
    ))
    public void listenerDirectQueue1(String msg){
        System.out.println("topic.q1 消费者1 消费接收到 【"+ msg +"】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topicQueue2"),
            exchange = @Exchange(name = "blithe.topic",type = ExchangeTypes.TOPIC),
            key = "china.#"
    ))
    public void listenerDirectQueue2(String msg){
        System.out.println("topic.q2 消费者2 消费接收到 【"+ msg +"】");
    }
}
