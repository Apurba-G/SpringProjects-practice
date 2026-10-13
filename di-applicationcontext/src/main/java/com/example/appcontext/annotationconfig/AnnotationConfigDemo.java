package com.example.appcontext.annotationconfig;

import com.example.appcontext.common.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AnnotationAppConfig.class);
        GreetingService gs = ctx.getBean(GreetingService.class);
        gs.greet();
        ctx.close();
    }
}