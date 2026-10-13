package com.example.lookup2.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.lookup2.common", "com.example.lookup2.annotation"})
public class LookupConfig {

}
