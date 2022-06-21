package com.week3.week3_94.week3_test3;

import com.week3.week3_94.week3_test3.Football;

public class MyRectangle extends Football {

	private double width;
	private double height;
    private double radius;

	public MyRectangle(double width,double height,String color, double weight) {
		super(color, weight);
		this.width = width;
		this.height = height;
	}

    public MyRectangle(String color, double weight) {
        super(color, weight);
    }

    public MyRectangle(String color, double weight, double width, double height, double radius) {
        super(color, weight);
        this.width = width;
        this.height = height;
        this.radius = radius;
    }

    public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

    @Override
    public double findVolume() {
        return 4/3*3.14 * radius * radius*radius;
    }

    @Override
    public double findArea() {
        return 4*3.14 * radius * radius;
    }
}
