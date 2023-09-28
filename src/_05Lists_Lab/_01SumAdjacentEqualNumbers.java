package _05Lists_Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class _01SumAdjacentEqualNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Double> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

		for (int i = 0; i < numbers.size(); i++) {
			if(i != numbers.size() - 1 && numbers.get(i).equals(numbers.get(i + 1))) {
				double sum = numbers.get(i) + numbers.get(i + 1);
				numbers.set(i, sum);
				numbers.remove(i + 1);
				i = - 1;
			}
		}

		String result = "";
		for (Double number : numbers) {
			result += new DecimalFormat("0.#").format(number) + " ";
		}
		System.out.println(result.trim());
//		for (Double number : numbers) {
//			System.out.print(number + " ");
//		}
	}
}
