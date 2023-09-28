package _13ExamPreparation1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03NeedForSpeedIII {
	public static class Garage {
		private final List<Car> cars;

		public Garage() {
			this.cars = new ArrayList<>();
		}

		public void add(Car car) {
			this.cars.add(car);
		}

		public void drive(String model, int distance, int fuel) {
			Car carForSale = null;

			for (Car car : cars) {
				if(car.getModel().equals(model)) {
					if(fuel > car.getFuel()) {
						System.out.println("Not enough fuel to make that ride");
					} else {
						int newMileage = car.getMileage() + distance;
						int newFuel = car.getFuel() - fuel;

						car.setMileage(newMileage);
						car.setFuel(newFuel);

						System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", model, distance, fuel);
					}

					if(car.getMileage() >= 100000) {
						carForSale = car;
						System.out.println("Time to sell the " + car.getModel() + "!");
					}
				}
			}

			if(carForSale != null) {
				cars.remove(carForSale);
			}
		}

		public void refuel(String model, int fuel) {
			for (Car car : cars) {
				if(car.getModel().equals(model)) {
					int tank = car.getFuel() + fuel;
					if(tank > 75) {
						tank = 75;
						fuel = 75 - car.getFuel();
					}
					car.setFuel(tank);
					System.out.printf("%s refueled with %d liters%n", car.getModel(), fuel);
				}
			}
		}

		public void revert(String model, int kms) {
			for (Car car : cars) {
				if(car.getModel().equals(model)) {
					int mileage = car.getMileage() - kms;
					System.out.printf("%s mileage decreased by %d kilometers%n", car.getModel(), kms);

					if(mileage < 10000) {
						car.setMileage(10000);
					} else {
						car.setMileage(mileage);
					}
				}
			}
		}

		@Override
		public String toString() {
			String result = "";
			for (Car car : cars) {
				result += car.getModel() + " -> Mileage: " + car.getMileage() + " kms, Fuel in the tank: " + car.getFuel() + " lt.\n";
			}
			return result;
		}
	}

	public static class Car {
		private final String model;
		private int mileage;
		private int fuel;

		public Car(String model, int mileage, int fuel) {
			this.model = model;
			this.mileage = mileage;
			this.fuel = fuel;
		}

		public void setMileage(int mileage) {
			this.mileage = mileage;
		}

		public void setFuel(int fuel) {
			this.fuel = fuel;
		}

		public String getModel() {
			return this.model;
		}

		public int getMileage() {
			return this.mileage;
		}

		public int getFuel() {
			return this.fuel;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Garage garage = new Garage();

		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= n; i++) {
			String[] inputStr = scanner.nextLine().split("\\|");

			String model = inputStr[0];
			int distance = Integer.parseInt(inputStr[1]);
			int fuel = Integer.parseInt(inputStr[2]);

			Car car = new Car(model, distance, fuel);
			garage.add(car);
		}

		String command;
		while(!"Stop".equals(command = scanner.nextLine())) {
			String[] inputArr = command.split(" : ");
			String cmd = inputArr[0];

			if(cmd.equals("Drive")) {
				String model = inputArr[1];
				int distance = Integer.parseInt(inputArr[2]);
				int fuel = Integer.parseInt(inputArr[3]);

				if(distance > 0 && fuel > 0) {
					garage.drive(model, distance, fuel);
				}
			} else if(cmd.equals("Refuel")) {
				String model = inputArr[1];
				int fuel = Integer.parseInt(inputArr[2]);

				if(fuel > 0) {
					garage.refuel(model, fuel);
				}
			} else if(cmd.equals("Revert")) {
				String model = inputArr[1];
				int kms = Integer.parseInt(inputArr[2]);

				if(kms > 0) {
					garage.revert(model, kms);
				}
			}
		}
		System.out.print(garage);
	}
}
