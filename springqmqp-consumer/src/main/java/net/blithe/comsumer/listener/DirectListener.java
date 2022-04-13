package net.blithe.comsumer.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectListener {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "directQueue1"),
            exchange = @Exchange(name = "blithe.direct",type = ExchangeTypes.DIRECT),
            key = {"blue","red"}
    ))
    public void listenerDirectQueue1(String msg){
        System.out.println("Direct 消费者1 消费接收到 【"+ msg +"】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "directQueue2"),
            exchange = @Exchange(name = "blithe.direct",type = ExchangeTypes.DIRECT),
            key = {"yellow","red"}
    ))
    public void listenerDirectQueue2(String msg){
        System.out.println("Direct 消费者2 消费接收到 【"+ msg +"】");
    }
}
