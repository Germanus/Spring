package my.ilya.demo;

import my.ilya.dao.HibernateDaoImpl;
import my.ilya.dao.JdbcDaoImpl;
import my.ilya.dao.SimpleJdbcDaoImpl;
import my.ilya.model.Circle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class JdbcDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int circleId = 2;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao =  ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		Circle circle = dao.getCircle(circleId);
		System.out.println("Circle name is \""+dao.getCircleName(2)+"\"");
		System.out.println("Circle count is \""+dao.getCircleCount()+"\"");
		
		Circle circle2 = new Circle(5,"CircleName555");
		//dao.insertCircle(circle2);
		System.out.println("List of circles is \""+dao.getAllCircles().size()+"\"");
		//System.out.println("Circle name is \""+dao.getCircleById(5).getName()+"\"");
		//dao.createTriangleTable();
		SimpleJdbcDaoImpl simpleDao =  ctx.getBean("dao.SimpleJdbcDaoImpl",SimpleJdbcDaoImpl.class);
		System.out.println(simpleDao.getCircleCount()+" is simpleJdbc SIZE");
		
		HibernateDaoImpl hibernateDao = ctx.getBean("hibernateDaoImpl",HibernateDaoImpl.class);
		System.out.println(hibernateDao.getCircleCount()+" is HIBERNATE size");
	}

}
