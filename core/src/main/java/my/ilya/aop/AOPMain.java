package my.ilya.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import my.ilya.service.FactoryService;
import my.ilya.service.ShapeService;

public class AOPMain {
	public static void main(String[] args) {
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//		ShapeService shapeService = ctx.getBean("shapeService",ShapeService.class);
		
		FactoryService factoryService = new FactoryService();
		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");		
		
		shapeService.getCircle();
		//shapeService.getCircle().setNameAndReturn("Dummy name");
		//System.out.println(shapeService.getCircle().getName());
		
		
	}
}
