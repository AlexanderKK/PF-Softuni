package _05Lists_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _05ListManipulationAdvanced {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		String command = scanner.nextLine();
		while(!command.equals("end")) {
			if(command.startsWith("Contains")) {
				int number = Integer.parseInt(command.split(" ")[1]);

				printContained(numbers, number);
			} else if(command.equals("Print even")) {
				printEvenOddNumbers(numbers, "even");
			} else if(command.equals("Print odd")) {
				printEvenOddNumbers(numbers, "odd");
			} else if(command.equals("Get sum")) {
				printSum(numbers);
			} else if(command.startsWith("Filter")) {
				String condition = command.split(" ")[1];
				int number = Integer.parseInt(command.split(" ")[2]);

				printFilteredNumbers(numbers, condition, number);
			}

			command = scanner.nextLine();
		}
	}

	private static void printContained(List<Integer> numbers, int number) {
		if(numbers.contains(number)) {
			System.out.println("Yes");
		} else {
			System.out.println("No such number");
		}
	}

	public static void printFilteredNumbers(List<Integer> numbers, String condition, int numberToFilter) {
		for (Integer number : numbers) {
			switch(condition) {
				case "<":
					if(number < numberToFilter) {
						System.out.print(number + " ");
					}
					break;
				case ">":
					if(number > numberToFilter) {
						System.out.print(number + " ");
					}
					break;
				case ">=":
					if(number >= numberToFilter) {
						System.out.print(number + " ");
					}
					break;
				case "<=":
					if(number <= numberToFilter) {
						System.out.print(number + " ");
					}
					break;
			}
		}
		System.out.println();
	}

	public static void printSum(List<Integer> numbers) {
		int sum = 0;
		for (Integer number : numbers) {
			sum += number;
		}
		System.out.println(sum);
	}

	public static void printEvenOddNumbers(List<Integer> numbers, String type) {
		for (Integer number : numbers) {
			if(type.equals("even") && number % 2 == 0) {
				System.out.print(number + " ");
			} else if(type.equals("odd") && number % 2 != 0) {
				System.out.print(number + " ");
			}
		}
		System.out.println();
	}
}
