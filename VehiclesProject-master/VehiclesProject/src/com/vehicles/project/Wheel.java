package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj) {
			return true;
		} if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Wheel wheel = (Wheel) obj;
		
		return brand == wheel.getBrand() && diameter == wheel.getDiameter();
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	@Override
	public String toString() {
		return "Wheel [brand=" + brand + ", diameter=" + diameter + "]";
	}
	
	
	
}
