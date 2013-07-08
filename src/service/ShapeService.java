package service;

import aspect.Loggable;
import model.Circle;
import model.Shape;
import model.Triangle;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;
	//@Loggable
	public Circle getCircle() {
		System.out.println("Circle called");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
}