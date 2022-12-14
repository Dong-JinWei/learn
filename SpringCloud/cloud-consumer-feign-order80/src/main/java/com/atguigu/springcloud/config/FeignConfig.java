package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignConfig {
    @Bean
    Logger.Level geignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
