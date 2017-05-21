package model.swing;

import java.util.ArrayList;

import java.util.LinkedList;

public class Point2D {

	private LinkedList<Double> point = new LinkedList<Double>();
	
	public Point2D(LinkedList list){
		point = list;
	}
	
	public Point2D(double d, double e, double f) {
		point = new LinkedList();
		point.add(d);
		point.add(e);
		point.add(f);
	}

	public Double getNum(){
		return point.get(0);
	}
	
	public void setNum(Double num){
		point.set(0,num); 
	}
	
	public Double getX(){
		return point.get(1);
	}
	
	public Double getY(){
		return point.get(2);
	}
	
	public void setX(Double x){
		point.set(1,x);
	}
	
	public void setY(Double y){
		point.set(2,y);
	}
	
}
