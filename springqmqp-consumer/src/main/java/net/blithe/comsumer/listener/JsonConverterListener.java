package net.blithe.comsumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JsonConverterListener {

    @RabbitListener(queues = "imple.names")
    public void jsonListener(Map<String,String> msg){
        System.out.println("接收到 json object"+ msg);

    }

}
