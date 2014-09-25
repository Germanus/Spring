package my.ilya.interceptor;

import my.ilya.model.Shape;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InterceptorDemo {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext cont = new ClassPathXmlApplicationContext("spring.xml");
		MtBean mtBean = (MtBean) cont.getBean(MtBean.class);
		mtBean.showValues();
	}
}
