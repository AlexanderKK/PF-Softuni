package _05Lists_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _07AppendArrays {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<String> numbersStr = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
		Collections.reverse(numbersStr);

		List<Integer> numbers = new ArrayList<>();
		for (String number : numbersStr) {
			//Разделяне на списъка на стринг масиви по разделител 1 празно място или повече
			String[] str = number.split("\\s+");

			for (int i = 0; i < str.length; i++) {
				if(!str[i].isBlank()) {
					numbers.add(Integer.parseInt(str[i]));
				}
			}
		}

		for (int number : numbers) {
			System.out.print(number + " ");
		}
	}
}
