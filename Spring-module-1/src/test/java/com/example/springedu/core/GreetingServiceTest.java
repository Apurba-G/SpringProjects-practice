package com.example.springedu.core;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.springedu.config.AppConfig;
import com.example.springedu.config.DataConfig;

@ExtendWith(SpringExtension.class)
//@ActiveProfiles("test")
@ContextConfiguration(classes = { 
		AppConfig.class,
		DataConfig.class})
public class GreetingServiceTest {
	@Autowired
    private GreetingService greetingService;

    @Test
    void testGreetingService() {
        assertNotNull(greetingService);
        greetingService.sayHello();
    }
}
