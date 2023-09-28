package _05Lists_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _07RemoveNegativesAndReverse {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

//		numbers.removeIf(number -> number < 0);   //премахва всички отрицателни числа в списъка
		List<Integer> positiveNumbers = new ArrayList<>();
		for (Integer number : numbers) {
			if(number >= 0) {
				positiveNumbers.add(number);
			}
		}

		Collections.reverse(positiveNumbers);
		if(positiveNumbers.size() == 0) {
			System.out.println("empty");
		} else {
			System.out.println(positiveNumbers.toString()
					.replace("[", "")
					.replace("]", "")
					.replaceAll(",", ""));
		}
	}
}
