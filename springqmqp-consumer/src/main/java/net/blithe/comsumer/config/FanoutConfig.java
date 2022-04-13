package net.blithe.comsumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("blithe.fanout");
    }

    @Bean
    public Queue queue1(){
        return new Queue("fanout.queue1");
    }

    @Bean
    public Binding exchangeBuilder1(FanoutExchange fanoutExchange, Queue queue1){
        Binding to = BindingBuilder.bind(queue1).to(fanoutExchange);
        return to;
    }

    @Bean
    public Queue queue2(){
        return new Queue("fanout.queue2");
    }

    @Bean
    public Binding exchangeBilder2(FanoutExchange fanoutExchange,Queue queue2){
        return BindingBuilder.bind(queue2).to(fanoutExchange);
    }
}
