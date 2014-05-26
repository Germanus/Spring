package my.ilya.demo;


import my.ilya.model.Shape;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AbstractApplicationContext cont = new ClassPathXmlApplicationContext("spring.xml");
		cont.registerShutdownHook();
		Shape shape = (Shape)cont.getBean("circle");
		shape.draw();
		//System.out.println(cont.getMessage("greeting", null, "Default Greeting", null));
	}
}
