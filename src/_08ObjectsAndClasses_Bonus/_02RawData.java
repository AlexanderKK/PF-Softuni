package _08ObjectsAndClasses_Bonus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _02RawData {
	public static class Car {
		private String model;
		private Engine engine;
		private Cargo cargo;
		private Tire tire;

		public Car(String model, Engine engine, Cargo cargo, Tire tire) {
			this.model = model;
			this.engine = engine;
			this.cargo = cargo;
			this.tire = tire;
		}

		public String getModel() {
			return model;
		}

		public Engine getEngine() {
			return engine;
		}

		public Cargo getCargo() {
			return cargo;
		}

		public Tire getTire() {
			return tire;
		}
	}

	public static class Engine {
		private int engineSpeed;
		private int enginePower;

		public Engine(int engineSpeed, int enginePower) {
			this.engineSpeed = engineSpeed;
			this.enginePower = enginePower;
		}

		public int getEnginePower() {
			return this.enginePower;
		}

		public int getEngineSpeed() {
			return this.engineSpeed;
		}
	}

	public static class Cargo {
		private int cargoWeight;
		private String cargoType;

		public Cargo(int cargoWeight, String cargoType) {
			this.cargoWeight = cargoWeight;
			this.cargoType = cargoType;
		}

		public int getCargoWeight() {
			return cargoWeight;
		}

		public String getCargoType() {
			return cargoType;
		}
	}

	public static class Tire {
		private List<Double> tiresPressure;
		private List<Integer> tiresAge;

		public Tire(double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age, double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
			this.tiresPressure = Arrays.asList(tire1Pressure, tire2Pressure, tire3Pressure, tire4Pressure);
			this.tiresAge = Arrays.asList(tire1Age, tire2Age, tire3Age, tire4Age);
		}

		public List<Double> getTiresPressure() {
			return tiresPressure;
		}

		public List<Integer> getTiresAge() {
			return tiresAge;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numberCars = Integer.parseInt(scanner.nextLine());

		List<Car> cars = new ArrayList<>();
		for (int i = 1; i <= numberCars; i++) {
			String[] input = scanner.nextLine().split("\\s+");

			String model = input[0];
			int engineSpeed = Integer.parseInt(input[1]);
			int enginePower = Integer.parseInt(input[2]);
			int cargoWeight = Integer.parseInt(input[3]);
			String cargoType = input[4];
			double tire1Pressure = Double.parseDouble(input[5]);
			int tire1Age = Integer.parseInt(input[6]);
			double tire2Pressure = Double.parseDouble(input[7]);
			int tire2Age = Integer.parseInt(input[8]);
			double tire3Pressure = Double.parseDouble(input[9]);
			int tire3Age = Integer.parseInt(input[10]);
			double tire4Pressure = Double.parseDouble(input[11]);
			int tire4Age = Integer.parseInt(input[12]);

			Car car = new Car(model, new Engine(engineSpeed, enginePower), new Cargo(cargoWeight, cargoType),
							  new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age));

			cars.add(car);
		}

		String input = scanner.nextLine();
		for (Car car : cars) {
			String cargoType = car.getCargo().getCargoType();
			if(input.equals(cargoType) && cargoType.equals("fragile")) {
				Tire tire = car.getTire();
				for (double tirePressure : tire.getTiresPressure()) {
					if(tirePressure < 1) {
						System.out.println(car.getModel());
						break;
					}
				}
			} else if(input.equals(cargoType) && cargoType.equals("flamable")) {
				if(car.getEngine().getEnginePower() > 250) {
					System.out.println(car.getModel());
				}
			}
		}
	}
}
