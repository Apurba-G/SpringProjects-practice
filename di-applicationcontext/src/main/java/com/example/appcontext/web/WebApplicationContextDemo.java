package com.example.appcontext.web;

import com.example.appcontext.common.GreetingService;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WebApplicationContextDemo {
    public static void main(String[] args) {
        // Simulate a servlet container
        MockServletContext servletContext = new MockServletContext();

        // Create and configure the root web application context
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.setServletContext(servletContext);
        ctx.register(WebConfig.class);
        ctx.refresh();

        // Store it in the ServletContext as the root context (like ContextLoaderListener does)
        servletContext.setAttribute(
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, ctx);

        // Later, any web component can retrieve it like this:
        WebApplicationContext retrievedCtx =
                WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        GreetingService gs = retrievedCtx.getBean(GreetingService.class);
        gs.greet();

        ctx.close();
    }
}