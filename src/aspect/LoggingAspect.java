package aspect;

import model.Circle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
public class LoggingAspect {
	
	@Before("allCirlceMethods()")
	public void loggingAdvice(JoinPoint joinPoint){
		Circle circle = (Circle)joinPoint.getTarget();
		//System.out.println(joinPoint.getSignature());
	}
	
	@AfterReturning(pointcut="args(name)", returning="returningString")
	public void stringArgumentMethods(String name, String returningString){
		System.out.println("A method that takes String arguments " + returningString);
	}
	
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void exeptionAdvice(String name, RuntimeException ex){
		System.out.println("An exeption has been thrown "+ex);
	}
	
	@Around("@annotation(aspect.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint prJoinPoint){
		Object returnValue = null;
		try {
			System.out.println("Before Advice");
			returnValue = prJoinPoint.proceed();
			System.out.println("After Returning");
			
		} catch (Throwable e) {
			System.out.println("After Throwing");
		}
		System.out.println("After Finally");
		return returnValue;
	}
	
	//@Around("allGetters()")
	public Object myAroundAdvice2(ProceedingJoinPoint prJoinPoint){
		Object returnValue = null;
		try {
			System.out.println("Before Advice");
			returnValue = prJoinPoint.proceed();
			System.out.println("After Returning");
			
		} catch (Throwable e) {
			System.out.println("After Throwing");
		}
		System.out.println("After Finally");
		return returnValue;
	}
	
	//@Pointcut("execution(* get*())")
	public void allGetters(){}
	
	@Pointcut("within(model.Circle)")
	public void allCirlceMethods(){}
	
	public void loggingAdvice(){
		System.out.println("Logging from the advice");
	}
}
