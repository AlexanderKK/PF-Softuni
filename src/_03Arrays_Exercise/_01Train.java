package _03Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _01Train {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		int[] numbers = new int[n];
		int sum = 0;

		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(scanner.nextLine());
			numbers[i] = number;
			sum += numbers[i];
		}

		StringBuilder result = new StringBuilder();
		for (int number : numbers) {
			result.append(number).append(" ");
		}

		System.out.println(result.toString().trim());
		System.out.println(sum);
	}
}
