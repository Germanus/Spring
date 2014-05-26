package my.ilya.service;

import my.ilya.aspect.LoggingAspect;
import my.ilya.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	public Circle getCircle(){
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
	
}
