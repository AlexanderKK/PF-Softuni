package _05Lists_Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class _02GaussTrick {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		List<Integer> numbersResult = new ArrayList<>();
		for (int i = 0; i < numbers.size() / 2; i++) {
			int firstNum = numbers.get(i);
			int lastNum = numbers.get(numbers.size() - 1 - i);
			numbersResult.add(firstNum + lastNum);
		}

		if(numbers.size() % 2 != 0) {
			numbersResult.add(numbers.get(numbers.size() / 2));
		}

		String result = numbersResult.toString().replace("[", "").replace("]", "").replaceAll(",", "");
		System.out.println(result);
	}
}
