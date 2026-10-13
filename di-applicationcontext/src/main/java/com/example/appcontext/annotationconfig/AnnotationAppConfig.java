package com.example.appcontext.annotationconfig;

import com.example.appcontext.common.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationAppConfig {
    @Bean
    public GreetingService greetingService() {
        GreetingService gs = new GreetingService();
        gs.setMessage("Hello from AnnotationConfigApplicationContext!");
        return gs;
    }
}