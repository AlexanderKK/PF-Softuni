package _03Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _07CondenseArrayToNumber2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

		int[] condensed = new int[numbers.length - 1];

		for (int i = 0; i < condensed.length; i++) {
			for (int j = 0; j < numbers.length - 1; j++) {
				condensed[j] = numbers[j] + numbers[j + 1];
			}
			numbers = condensed;
		}

		System.out.println(numbers[0]);
	}
}
