package com.example.springedu.data;

import org.springframework.context.annotation.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private UserDao userDao;
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("DATA INITIALIZER STARTED");
		// DELETE OLD DATA
        userDao.deleteAll();
		//userDao.createTable();
		userDao.save(new User("Krish", "k@k.com"));
		userDao.save(new User("Apurba", "a@a.com"));
		userDao.save(new User("Dipu", "d@d.com"));
		userDao.save(new User("Suvo", "s@s.com"));
		System.out.println("=== Database initialized with sample users ===");
		userDao.findAll().forEach(u->System.out.println("User: "+u.getName()+"_"+u.getEmail()));
		
	}
	
	
	
}
