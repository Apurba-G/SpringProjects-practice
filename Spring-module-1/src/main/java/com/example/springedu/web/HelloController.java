package com.example.springedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("/api/hello")
	@ResponseBody
	public String sayHello() {
		return "Hello from Spring Web MVC";
	}

}
