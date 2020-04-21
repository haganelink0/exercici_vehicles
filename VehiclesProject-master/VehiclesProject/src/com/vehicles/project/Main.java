package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Car userCar = createCar(reader);
		System.out.println(userCar);
		reader.close();


	}
	
	public static Car createCar(Scanner reader) {
		String plate = createPlate(reader);
		System.out.println("Please, insert the car's brand:");
		String brand = reader.nextLine();
		System.out.println("Please, insert the car's color:");
		String color = reader.nextLine();
		Car userCar = new Car(plate, brand, color);
		System.out.println("Now, we will add the front wheels.");
		List<Wheel> frontWheels = createWheels(reader);
		System.out.println("Now, we will add the back wheels");
		List<Wheel> backWheels = createWheels(reader);
		try {
			userCar.addWheels(frontWheels, backWheels);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userCar;
	}
	
	public static boolean checkPlate(String plate) {
		int amountOfNumbers = 0;
		int amountOfLetters = 0;
		for(int i = 0; i < plate.length(); i++) {
			if (Character.isDigit(plate.charAt(i))) {
				amountOfNumbers++;
			} else if (Character.isLetter(plate.charAt(i))) {
				amountOfLetters++;
			}
		}
		 if (amountOfNumbers == 4 && amountOfLetters < 4 && amountOfLetters > 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String createPlate(Scanner reader) {
		while(true) {
			System.out.println("Please, insert the car plate number:");
			String plate = reader.nextLine();
			if (checkPlate(plate)) {
				return plate;
			} else {
				System.out.println("The plate isn't valid. Please insert a plate with 4 numbers and two or three letters.");
			}
		}
		
	}
	
	public static List<Wheel> createWheels(Scanner reader) {
		System.out.println("Insert the brand of the front wheels:");
		String wheelBrand = reader.nextLine();
		while(true) {
			System.out.println("Insert the diammeter of the front wheels:");
			double diameter = Double.parseDouble(reader.nextLine());
			if (diameter < 4 && diameter > 0.4) {
				Wheel wheel = new Wheel(wheelBrand, diameter);
				Wheel right = wheel;
				Wheel left = wheel;
				List<Wheel> wheels = new ArrayList<Wheel>();
				wheels.add(right);
				wheels.add(left);
				return wheels;
			} else {
				System.out.println("The diameter of the wheel isn't valid. Please insert a number lower than 4 and higher than 0.4");
			}
			
		}
		


	}
	

}
