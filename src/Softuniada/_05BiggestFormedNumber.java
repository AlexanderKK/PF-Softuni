package Softuniada;

import java.util.*;
import java.util.stream.Collectors;

public class _05BiggestFormedNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> numSequence = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		numSequence.sort((num1, num2) -> {
			String first = num1.toString() + num2.toString();
			String second = num2.toString() + num1.toString();
			return second.compareTo(first);
		});

		String biggestNumber = "";
		for (int number : numSequence) {
			biggestNumber += number;
		}

		System.out.println(biggestNumber);
	}
}
