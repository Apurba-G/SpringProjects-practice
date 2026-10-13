package com.example.springedu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.springedu.config.AopConfig;
import com.example.springedu.config.AppConfig;
import com.example.springedu.config.DataConfig;

@ExtendWith(SpringExtension.class)
//@ActiveProfiles("test")
@ContextConfiguration(classes = { AppConfig.class, DataConfig.class, AopConfig.class })
public class SpringContextTest {
	@Test
	void contextLoads() {
		// verify that the context starts
	}
}
