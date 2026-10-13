package com.example.strategy.spring.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.strategy.spring.xml.XmlSorter;

public class XmlRunner {
	public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("strategy-config.xml");
        XmlSorter sorter = ctx.getBean(XmlSorter.class);
        sorter.sort(new int[]{3, 1, 4});
    }
}
