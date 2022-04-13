package com.blithe.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class AppTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testSendMessage2SimpleQueue() {
        String queueName = "simple.name";
        String message = "Hello Spring amqp";
        Map<String,String> map = new HashMap<>();
        map.put("key1","testingConveter");
        rabbitTemplate.convertAndSend(queueName, map);
    }

    @Test
    void testFanoutQ() {
        String exchangeName = "blithe.fanout";

        rabbitTemplate.convertAndSend(exchangeName,"","");
    }

    @Test
    void testDirectQ() {
        String exchangeName = "blithe.direct";
        rabbitTemplate.convertAndSend(exchangeName,"yellow","hello everyone by yellow!!!!");
    }

    @Test
    void testTopicQ() {
        String exchangeName = "blithe.topic";
        rabbitTemplate.convertAndSend(exchangeName,"china.news","中国的新闻！！!!!!");
    }

    @Test
    void testTopic2Q() {
        String exchangeName = "blithe.topic";
        rabbitTemplate.convertAndSend(exchangeName,"japan.news","日本的新闻！！!!!!");
    }
}