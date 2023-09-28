package _08ObjectsAndClasses_Bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03CarSalesman {
	static class Engine {
		private String model;
		private int power;
		private Object displacement;
		private String efficiency;

		public Engine(String model, int power) {
			this.model = model;
			this.power = power;
			this.displacement = "n/a";
			this.efficiency = "n/a";
		}

		public Engine(String model, int power, String efficiency) {
			this.model = model;
			this.power = power;
			this.displacement = "n/a";
			this.efficiency = efficiency;
		}

		public Engine(String model, int power, int displacement) {
			this.model = model;
			this.power = power;
			this.displacement = displacement;
			this.efficiency = "n/a";
		}

		public Engine(String model, int power, int displacement, String efficiency) {
			this.model = model;
			this.power = power;
			this.displacement = displacement;
			this.efficiency = efficiency;
		}

		public String getModel() {
			return model;
		}

		public int getPower() {
			return power;
		}

		public Object getDisplacement() {
			return displacement;
		}

		public String getEfficiency() {
			return efficiency;
		}
	}

	static class Car {
		private String model;
		private Engine engine;
		private Object weight;
		private String color;

		@Override
		public String toString() {
			return this.getModel() + ":\n  " + this.engine.getModel() +
					":\n    Power: " + this.engine.getPower() +
					"\n    Displacement: " + this.engine.getDisplacement() + "\n    Efficiency: " + this.engine.getEfficiency() +
					"\n  Weight: " + this.getWeight() + "\n  Color: " + this.getColor();
		}

		public Car(String model, Engine engine) {
			this.model = model;
			this.engine = engine;
			this.weight = "n/a";
			this.color = "n/a";
		}

		public Car(String model, Engine engine, int weight) {
			this.model = model;
			this.engine = engine;
			this.weight = weight;
			this.color = "n/a";
		}

		public Car(String model, Engine engine, String color) {
			this.model = model;
			this.engine = engine;
			this.weight = "n/a";
			this.color = color;
		}

		public Car(String model, Engine engine, int weight, String color) {
			this.model = model;
			this.engine = engine;
			this.weight = weight;
			this.color = color;
		}

		public String getModel() {
			return model;
		}

		public Object getWeight() {
			return weight;
		}

		public String getColor() {
			return color;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int engineCount = Integer.parseInt(scanner.nextLine());
		List<Engine> engines = new ArrayList<>();
		for (int i = 1; i <= engineCount; i++) {
			String[] input = scanner.nextLine().split(" ");

			Engine engine;
			if(input.length == 2) {
				engine = new Engine(input[0], Integer.parseInt(input[1]));
			} else if(input.length == 3) {
				try {
					int displacement = Integer.parseInt(input[2]);
					engine = new Engine(input[0], Integer.parseInt(input[1]), displacement);
				} catch(Exception e) {
					engine = new Engine(input[0], Integer.parseInt(input[1]), input[2]);
				}
			} else {
				engine = new Engine(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), input[3]);
			}
			engines.add(engine);
		}

		int carsCount = Integer.parseInt(scanner.nextLine());
		List<Car> cars = new ArrayList<>();

		for (int i = 1; i <= carsCount; i++) {
			String[] input = scanner.nextLine().split(" ");

			Engine eng = null;
			//if engine model equals the car model input -> add engine Object to car Object
			for (Engine engine : engines) {
				if(engine.getModel().equals(input[1])) {
					eng = engine;
				}
			}

			Car car;
			if(input.length == 2) {
				car = new Car(input[0], eng);
			} else if(input.length == 3) {
				try {
					int weight = Integer.parseInt(input[2]);
					car = new Car(input[0], eng, weight);
				} catch(Exception e) {
					car = new Car(input[0], eng, input[2]);
				}
			} else {
				car = new Car(input[0], eng, Integer.parseInt(input[2]), input[3]);
			}

			cars.add(car);
		}

		for (Car car : cars) {
			System.out.println(car);
		}
	}
}
