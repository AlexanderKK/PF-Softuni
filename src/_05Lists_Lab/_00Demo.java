package _05Lists_Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _00Demo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numbers =
				Arrays.stream(scanner.nextLine()
				.split(" ")).map(Integer::parseInt)
						.collect(Collectors.toList());
		List<Double> decimalNumbers =
				Arrays.stream(scanner.nextLine()
						.split(" ")).map(Double::parseDouble).toList();

		List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

		List<Integer> numbers1 = new ArrayList<>();
		numbers1.add(9);
		numbers1.add(4);
		numbers1.add(5);
		numbers1.add(9);
		numbers1.add(1);
		numbers1.add(9);

		//Hardcoding
		List<Double> grades = new ArrayList<>(Arrays.asList(1.2,2.4,3.5,4.9));
	}
}
