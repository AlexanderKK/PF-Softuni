package _03Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _03SumEvenNumbers2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		int[] numbers = Arrays
				.stream(input.split(" "))
				.mapToInt(e -> Integer.parseInt(e))
				.toArray();

		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] % 2 == 0) {
				sum += numbers[i];
			}
		}
		System.out.println(sum);
	}
}
