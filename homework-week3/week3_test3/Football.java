package com.week3.week3_94.week3_test3;

public abstract class Football   {

	protected String color;
	protected double weight;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Football(String color, double weight) {
        super();

        this.color = color;
        this.weight = weight;


    }
	
	public abstract double findVolume();
	public abstract double findArea();
	
}
