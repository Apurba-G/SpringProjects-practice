package com.example.appcontext.filesystemxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.example.appcontext.common.GreetingService;

public class FileSystemXmlDemo {
	public static void main(String[] args) {
        // Works when running from the project root directory (where the "config" folder exists)
        ApplicationContext ctx = new FileSystemXmlApplicationContext("config/fs-context.xml");
        GreetingService gs = ctx.getBean(GreetingService.class);
        gs.greet();
    }
}
