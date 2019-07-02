package com.sample.di.demo5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo5App {

	public static void main(String[] args) {
		
		String resource = "classpath:/com/sample/di/demo5/demo05.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		UserService userService = ctx.getBean("userService", UserService.class );
		userService.addNewUser("판다", "panda", "1234");
		
	}
}
