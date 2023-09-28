package _13ExamPreparation1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03NeedForSpeedIV {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		LinkedHashMap<String, Integer> carsDistance = new LinkedHashMap<>();
		LinkedHashMap<String, Integer> carsFuel = new LinkedHashMap<>();

		for (int i = 1; i <= n; i++) {
			String[] inputArr = scanner.nextLine().split("\\|");

			String carName = inputArr[0];
			int mileage = Integer.parseInt(inputArr[1]);
			int fuel = Integer.parseInt(inputArr[2]);

			carsDistance.put(carName, mileage);
			carsFuel.put(carName, fuel);
		}

		String command;
		while (!(command = scanner.nextLine()).equals("Stop")) {
			String[] inputArr = command.split(" : ");
			String cmd = inputArr[0];

			if (cmd.equals("Drive")) {
				String model = inputArr[1];
				int distance = Integer.parseInt(inputArr[2]);
				int fuel = Integer.parseInt(inputArr[3]);

				if (fuel > carsFuel.get(model)) {
					System.out.println("Not enough fuel to make that ride");
				} else {
					carsDistance.put(model, carsDistance.get(model) + distance);
					carsFuel.put(model, carsFuel.get(model) - fuel);

					System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
							inputArr[1], distance, fuel);
				}

				if (carsDistance.get(model) >= 100000) {
					System.out.printf("Time to sell the %s!%n", model);

					carsDistance.remove(model);
					carsFuel.remove(model);
				}
			}

			if (cmd.equals("Refuel")) {
				String model = inputArr[1];
				int fuel = Integer.parseInt(inputArr[2]);
				int tank = carsFuel.get(model) + fuel;

				if(tank > 75) {
					fuel = 75 - carsFuel.get(model);
					carsFuel.put(model, 75);
				} else {
					carsFuel.put(model, tank);
				}
				System.out.printf("%s refueled with %d liters%n", model, fuel);
			}

			if (cmd.equals("Revert")) {
				String model = inputArr[1];
				int kms = Integer.parseInt(inputArr[2]);

				carsDistance.put(model, carsDistance.get(model) - kms);

				if (carsDistance.get(model) < 10000) {
					carsDistance.put(model, 10000);
				} else {
					System.out.printf("%s mileage decreased by %d kilometers%n", model, kms);
				}
			}
		}

		for (Map.Entry<String, Integer> entry : carsDistance.entrySet()) {
			System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue(), carsFuel.get(entry.getKey()));
		}
	}
}
