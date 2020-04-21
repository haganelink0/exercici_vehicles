package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please, insert the car plate number:");
		String plate = reader.nextLine();
		System.out.println("Please, insert the car's brand:");
		String brand = reader.nextLine();
		System.out.println("Please, insert the car's color:");
		String color = reader.nextLine();
		Car userCar = new Car(plate, brand, color);
		System.out.println("Now, we will add the wheels.");
		System.out.println("Insert the brand of the front wheels:");
		String wheelBrand = reader.nextLine();
		System.out.println("Insert the diammeter of the front wheels:");
		double frontDiammeters = Double.parseDouble(reader.nextLine());
		Wheel frontRight = new Wheel(wheelBrand, frontDiammeters);
		Wheel frontLeft = new Wheel(wheelBrand, frontDiammeters);
		List<Wheel> frontWheels = new ArrayList<Wheel>();
		frontWheels.add(frontRight);
		frontWheels.add(frontLeft);
		System.out.println("Insert the brand of the back wheels:");
		String backWheelBrand = reader.nextLine();
		System.out.println("Insert the diammeter of the back wheels:");
		double backDiammeter = Double.parseDouble(reader.nextLine());
		Wheel backRight = new Wheel(backWheelBrand, backDiammeter);
		Wheel backLeft = new Wheel(backWheelBrand, backDiammeter);
		List<Wheel> backWheels = new ArrayList<Wheel>();
		backWheels.add(backLeft);
		backWheels.add(backRight);
		try {
			userCar.addWheels(frontWheels, backWheels);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(userCar);


	}

}
