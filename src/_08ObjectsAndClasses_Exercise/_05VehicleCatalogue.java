package _08ObjectsAndClasses_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _05VehicleCatalogue {
	public static class Vehicle {
		private String type;
		private String model;
		private String color;
		private int horsePower;

		public Vehicle(String type, String model, String color, int horsePower) {
			this.type = type;
			this.model = model;
			this.color = color;
			this.horsePower = horsePower;
		}

		public String getType() {
			return String.valueOf(this.type.charAt(0)).toUpperCase() + this.type.substring(1);
		}

		public String getModel() {
			return this.model;
		}

		public String getColor() {
			return this.color;
		}

		public int getHorsePower() {
			return this.horsePower;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Vehicle> vehicles = new ArrayList<>();

		//Add vehicle to vehicles
		appendVehicles(scanner, vehicles);

		//Print vehicles by model
		printVehicles(scanner, vehicles);

		int carsCount = 0;
		int trucksCount = 0;

		int sumHorsePowerCars = 0;
		int sumHorsePowerTrucks = 0;

		for (Vehicle vehicle : vehicles) {
			if(vehicle.getType().equals("Car")) {
				carsCount++;
				sumHorsePowerCars += vehicle.getHorsePower();
			} else if(vehicle.getType().equals("Truck")) {
				trucksCount++;
				sumHorsePowerTrucks += vehicle.getHorsePower();
			}
		}

		//Get average horsepower of cars and trucks
		printAverageHorsepower(carsCount, trucksCount, sumHorsePowerCars, sumHorsePowerTrucks);
	}

	private static void printAverageHorsepower(int carsCount, int trucksCount, int sumHorsePowerCars, int sumHorsePowerTrucks) {
		double avgHorsePowerCars = 0;
		double avgHorsePowerTrucks = 0;
		if(carsCount > 0) {
			avgHorsePowerCars = sumHorsePowerCars * 1.0 / carsCount;
		}
		if(trucksCount > 0) {
			avgHorsePowerTrucks = sumHorsePowerTrucks * 1.0 / trucksCount;
		}

		System.out.printf("Cars have average horsepower of: %.2f.%n", avgHorsePowerCars);
		System.out.printf("Trucks have average horsepower of: %.2f.%n", avgHorsePowerTrucks);
	}

	private static void printVehicles(Scanner scanner, List<Vehicle> vehicles) {
		String command;
		while(!(command = scanner.nextLine()).equals("Close the Catalogue")) {
			for (Vehicle vehicle : vehicles) {
				if(vehicle.getModel().equals(command)) {
					String dataVehicle = String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d%n", vehicle.getType(), vehicle.getModel(), vehicle.getColor(), vehicle.getHorsePower());
					System.out.print(dataVehicle);
				}
			}
		}
	}

	private static void appendVehicles(Scanner scanner, List<Vehicle> vehicles) {
		String command;
		while(!(command = scanner.nextLine()).equals("End")) {
			String[] input = command.split(" ");

			Vehicle vehicle = new Vehicle(input[0], input[1], input[2], Integer.parseInt(input[3]));
			vehicles.add(vehicle);
		}
	}
}