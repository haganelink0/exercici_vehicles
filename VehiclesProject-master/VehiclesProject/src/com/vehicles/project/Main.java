package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Vehicle userVehicle = createVehicle(reader);
		System.out.println(userVehicle);
		reader.close();


	}
	
	//Asks the user if he wants to create a bike or a car and proceeds with it.
	public static Vehicle createVehicle(Scanner reader) {
		while(true) {
			System.out.println("What do you want o create, a bike or a car");
			String vehicle = reader.nextLine();
			if (vehicle.equalsIgnoreCase("bike") || vehicle.equalsIgnoreCase("car")) {
				String plate = createPlate(reader);
				System.out.println("Please, insert the brand:");
				String brand = reader.nextLine();
				System.out.println("Please, insert the color:");
				String color = reader.nextLine();
				if (vehicle.equalsIgnoreCase("car")) {
					Car userCar = createCar(reader, plate, brand, color);
					return userCar;
				} else {
					Bike userBike = createBike(reader, plate, brand, color);
					return userBike;
				}
			} else {
				System.out.println("Invalid keyword.");
			}
		}
		
	}
	
	//asks the user for the wheels and creates a car
	public static Car createCar(Scanner reader, String plate, String brand, String color) {
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
	
	//checks if the plate contains a valid amount of numbers and letters
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
	
	//creates a valid plate
	public static String createPlate(Scanner reader) {
		while(true) {
			System.out.println("Please, insert the plate number:");
			String plate = reader.nextLine();
			if (checkPlate(plate)) {
				return plate;
			} else {
				System.out.println("The plate isn't valid. Please insert a plate with 4 numbers and two or three letters.");
			}
		}	
	}
	
	//creates a List of two equal wheels
	public static List<Wheel> createWheels(Scanner reader) {
			Wheel wheel = createWheel(reader);
			Wheel right = wheel;
			Wheel left = wheel;
			List<Wheel> wheels = new ArrayList<Wheel>();
			wheels.add(right);
			wheels.add(left);
			return wheels;
	}
	
	//creates a single wheel with the right parameters
	public static Wheel createWheel(Scanner reader) {
		System.out.println("Insert the brand of the wheel:");
		String wheelBrand = reader.nextLine();
		while(true) {
			System.out.println("Insert the diammeter of the wheel:");
			double diameter = Double.parseDouble(reader.nextLine());
			if (diameter < 4 && diameter > 0.4) {
				Wheel wheel = new Wheel(wheelBrand, diameter);
				return wheel;
			} else {
				System.out.println("The diameter of the wheel isn't valid. Please insert a number lower than 4 and higher than 0.4");
			}	
		}
	}
	
	//aks the user for the wheels and creates a bike
	public static Bike createBike(Scanner reader, String plate, String brand, String color) {
		Bike userBike = new Bike(plate, brand, color);
		System.out.println("Now we will add the front wheel");
		Wheel frontWheel = createWheel(reader);
		System.out.println("Now we will add the back wheel");
		Wheel backWheel = createWheel(reader);
		List<Wheel> wheels = new ArrayList<Wheel>();
		wheels.add(backWheel);
		wheels.add(frontWheel);
		try {
			userBike.addWheels(wheels);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userBike;
	}
	

}
