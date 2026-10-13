package com.example.appcontext.web;

public class RequestScopedBean {
    public RequestScopedBean() {
        System.out.println("RequestScopedBean created (inside a request)");
    }
}