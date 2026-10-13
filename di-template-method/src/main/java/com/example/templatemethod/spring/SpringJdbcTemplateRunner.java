package com.example.templatemethod.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJdbcTemplateRunner {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

		EmployeeDao dao = ctx.getBean(EmployeeDao.class);

		dao.createTable();
		dao.insertEmployee(1, "Alice");
		dao.insertEmployee(2, "Bob");

		System.out.println("Employee 1: " + dao.getEmployeeName(1));
		System.out.println("Employee 2: " + dao.getEmployeeName(2));

		ctx.close();
	}
}
