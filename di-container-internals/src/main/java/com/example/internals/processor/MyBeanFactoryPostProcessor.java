package com.example.internals.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{
	
	 @Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException{
		 System.out.println("\n[BeanFactoryPostProcessor] Running...");
		 System.out.println("Total bean definitions loaded: " + factory.getBeanDefinitionCount());
		 System.out.println("Bean definition names:");
		 for (String name : factory.getBeanDefinitionNames()) {
	            System.out.println(" - " + name);
	        }
	        System.out.println("[BeanFactoryPostProcessor] Finished.\n");
		 
	}

}
