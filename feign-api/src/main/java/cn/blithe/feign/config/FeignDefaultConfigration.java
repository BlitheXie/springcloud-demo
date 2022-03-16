package cn.blithe.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignDefaultConfigration {

    @Bean
    public Logger.Level getLevel(){
        return Logger.Level.FULL;
    }

}
