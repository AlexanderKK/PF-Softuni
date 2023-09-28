package _03Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _04ArrayRotation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int rotations = Integer.parseInt(scanner.nextLine());

		for (int i = 1; i <= rotations; i++) {
			int first = numbers[0];

			for (int j = 0; j < numbers.length; j++) {
				if(j == numbers.length - 1) {
					numbers[numbers.length - 1] = first;
				} else {
					numbers[j] = numbers[j + 1];
				}
			}
		}

		String result = "";
		for (int number : numbers) {
			result += number + " ";
		}
		System.out.println(result.trim());
	}
}
