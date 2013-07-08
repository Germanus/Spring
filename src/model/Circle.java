package model;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import main.DrawEvent;
import main.Point;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Entity
public class Circle{// implements Shape, ApplicationEventPublisherAware{
	@Transient
	private Point center;
	@Id
	private int id;
	private String name;
	@Transient
	private ApplicationEventPublisher publisher;
	@Autowired
	@Transient
	private MessageSource messageSource;
	
	
	public Circle() {}
	
	public Circle(int circleId, String name) {
		this.id=circleId;
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void draw() {
		System.out.println(messageSource.getMessage("greeting", null, "Default Greeting", Locale.US));
		System.out.println(messageSource.getMessage("drawing.circle", null, "Default Drawing Message", null));
		System.out.println(messageSource.getMessage("drawing.point", new Object[]{center.getX(),center.getY()}, "Default Drawing Message", null));
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}

	public Point getCenter() {
		return center;
	}
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}
	@PostConstruct
	public void initializeCircle(){
		System.out.println("Init of Circle");
	}
	@PreDestroy
	public void destroyCircle(){
		System.out.println("Destroy of Circle");
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}
	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}


	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher=publisher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("...");
		//throw(new RuntimeException());
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("...");
		return name;
	}
}
