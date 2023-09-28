package _07MidExam;

import java.util.*;
import java.util.stream.*;

public class _02CoffeeLover {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<String> coffees = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

		int lines = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= lines; i++) {
			String[] input = scanner.nextLine().split(" ");
			String cmd = input[0];

			if(cmd.equals("Include")) {
				String coffee = input[1];

				coffees.add(coffee);
			} else if(cmd.equals("Remove")) {
				String firstOrLast = input[1];
				int numberOfCoffees = Integer.parseInt(input[2]);

				removeFirstOrLastCoffees(coffees, firstOrLast, numberOfCoffees);
			} else if(cmd.equals("Prefer")) {
				int firstCoffeeIndex = Integer.parseInt(input[1]);
				int secondCoffeeIndex = Integer.parseInt(input[2]);

				swapCoffees(coffees, firstCoffeeIndex, secondCoffeeIndex);
			} else if(cmd.equals("Reverse")) {
				Collections.reverse(coffees);
			}
		}

		System.out.printf("Coffees:%n%s%n", String.join(" ", coffees));
	}

	private static void swapCoffees(List<String> coffees, int firstCoffeeIndex, int secondCoffeeIndex) {
		if(areValidIndexes(coffees, firstCoffeeIndex, secondCoffeeIndex)) {
			String firstCoffee = coffees.get(firstCoffeeIndex);
			String secondCoffee = coffees.get(secondCoffeeIndex);

			coffees.set(firstCoffeeIndex, secondCoffee);
			coffees.set(secondCoffeeIndex, firstCoffee);
		}
	}

	private static void removeFirstOrLastCoffees(List<String> coffees, String firstOrLast, int numberOfCoffees) {
		if(numberOfCoffees <= coffees.size()) {
			for (int i = 1; i <= numberOfCoffees; i++) {
				if(firstOrLast.equals("first")) {
					coffees.remove(0);
				} else if(firstOrLast.equals("last")) {
					coffees.remove(coffees.size() - 1);
				}
			}
		}
	}

	private static boolean areValidIndexes(List<String> coffees, int firstCoffeeIndex, int secondCoffeeIndex) {
		return firstCoffeeIndex >= 0 && firstCoffeeIndex <= coffees.size() - 1 && secondCoffeeIndex >= 0 && secondCoffeeIndex <= coffees.size() - 1;
	}
}
