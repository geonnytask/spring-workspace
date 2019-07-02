package com.sample.di.demo3;

import java.io.ObjectInputStream.GetField;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo3App {

	public static void main(String[] args) {
		String resource = "classpath:/com/sample/di/demo3/demo3.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		SampleController controller = ctx.getBean("controller", SampleController.class);
		
		controller.add("panda", "zxcv1234");
	}
}
