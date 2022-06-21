package com.week3.week3_94.week3_test3;

import com.week3.week3_94.week3_test3.Football;

public class Circle extends Football {

	private double radius;
	
	public Circle(double radius,String color, double weight) {
		super(color, weight);
		this.radius = radius;
	}



    public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double findVolume(){
		return 4/3*3.14 * radius * radius*radius;
	}

    public double findArea(){
        return 4*3.14 * radius * radius;
    }

}
