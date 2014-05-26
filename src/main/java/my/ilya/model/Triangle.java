package my.ilya.model;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape,ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean{
	
	private ApplicationContext context = null;
	
	private String type;
	private String name;
	private int height;
	
	private List<Point> points;
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	

	public void draw(){
		
//		System.out.println(getPointA().getX()+" "+getPointA().getY());
//		System.out.println(getPointB().getX()+" "+getPointB().getY());
//		System.out.println(getPointC().getX()+" "+getPointC().getY());
		System.out.println("Drawing Triangle");
		for(Point p: points){
			System.out.println("Point ("+p.getX()+","+p.getY()+");");
		}
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean name is: "+beanName);
		
	}
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializationBean init method called for Triangle");		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean init method called for Triangle");		
	}
	
	public void myInit(){
		System.out.println("MyInit method called for Triangle");
	}
	public void cleanUp(){
		System.out.println("CleanUp method called for Triangle");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
