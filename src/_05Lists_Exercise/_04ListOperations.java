package _05Lists_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _04ListOperations {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
								.collect(Collectors.toList());

		String command = scanner.nextLine();
		while(!command.equals("End")) {
			if(command.startsWith("Add")) {
				int element = Integer.parseInt(command.split(" ")[1]);

				numbers.add(element);
			} else if(command.startsWith("Insert")) {
				int element = Integer.parseInt(command.split(" ")[1]);
				int index = Integer.parseInt(command.split(" ")[2]);

				checkValidIndexInsert(numbers, element, index);
			} else if(command.startsWith("Remove")) {
				int index = Integer.parseInt(command.split(" ")[1]);

				checkValidIndexRemove(numbers, index);
			} else if(command.startsWith("Shift left")) {
				int count = Integer.parseInt(command.split(" ")[2]);

				shiftLeft(numbers, count);
			} else if(command.startsWith("Shift right")) {
				int count = Integer.parseInt(command.split(" ")[2]);

				shiftRight(numbers, count);
			}
			command = scanner.nextLine();
		}

		for (int number : numbers) {
			System.out.print(number + " ");
		}
	}

	private static void shiftRight(List<Integer> numbers, int count) {
//		while(count > 0) {
//			int lastElement = numbers.get(numbers.size() - 1);
//			for (int i = numbers.size() - 1; i >= 0; i--) {
//				if(i == 0) {
//					numbers.set(0, lastElement);
//				} else {
//					numbers.set(i, numbers.get(i - 1));
//				}
//			}
//
//			count--;
//		}

		for (int i = 1; i <= count; i++) {
			int lastNumber = numbers.get(numbers.size() - 1);
			numbers.remove(numbers.size() - 1);
			numbers.add(0, lastNumber);
		}
	}

	private static void shiftLeft(List<Integer> numbers, int count) {
//		while(count > 0) {
//			int firstElement = numbers.get(0);
//			for (int i = 0; i < numbers.size(); i++) {
//				if(i == numbers.size() - 1) {
//					numbers.set(numbers.size() - 1, firstElement);
//				} else {
//					numbers.set(i, numbers.get(i + 1));
//				}
//			}
//
//			count--;
//		}

		for (int i = 1; i <= count; i++) {
			int firstNumber = numbers.get(0);
			numbers.remove(0);
			numbers.add(firstNumber);
		}
	}

	private static void checkValidIndexInsert(List<Integer> numbers, int element, int index) {
		if(index >= 0 && index <= numbers.size() - 1) {
			numbers.add(index, element);
		} else {
			System.out.println("Invalid index");
		}
	}

	private static void checkValidIndexRemove(List<Integer> numbers, int index) {
		if(index >= 0 && index <= numbers.size() - 1) {
			numbers.remove(index);
		} else {
			System.out.println("Invalid index");
		}
	}
}
