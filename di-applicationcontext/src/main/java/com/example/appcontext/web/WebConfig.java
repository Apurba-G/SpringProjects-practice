package com.example.appcontext.web;

import com.example.appcontext.common.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public GreetingService greetingService() {
        GreetingService gs = new GreetingService();
        gs.setMessage("Hello from WebApplicationContext (AnnotationConfigWebApplicationContext)!");
        return gs;
    }
}