package com.sample.di.demo4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo4App {
	
	public static void main(String[] args) {
		String resource = "classpath:/com/sample/di/demo4/demo04.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		EventNoticeService s1 = ctx.getBean("eventNoticeService", EventNoticeService.class);
		OrderService s2 = ctx.getBean("orderService", OrderService.class);
		
		s1.notice("70% 파격세일!!");
		s2.sendOrderStatus();
	}
}
