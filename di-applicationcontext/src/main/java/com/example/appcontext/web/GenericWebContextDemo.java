package com.example.appcontext.web;

import com.example.appcontext.common.GreetingService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

public class GenericWebContextDemo {
    public static void main(String[] args) {
        MockServletContext servletContext = new MockServletContext();
        GenericWebApplicationContext ctx = new GenericWebApplicationContext();
        ctx.setServletContext(servletContext);
        ctx.getEnvironment().setActiveProfiles("web");
        new XmlBeanDefinitionReader(ctx).loadBeanDefinitions("classpath:web-beans.xml");
        ctx.refresh();

        // Retrieve a singleton bean – works fine
        GreetingService gs = ctx.getBean(GreetingService.class);
        gs.greet();

        // Trying to get a request-scoped bean without an active request
        try {
            RequestScopedBean rsb = ctx.getBean(RequestScopedBean.class);
            System.out.println(rsb);
        } catch (Exception e) {
            System.out.println("Cannot get request-scoped bean: " + e.getMessage());
        }

        ctx.close();
    }
}