package _03Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _05EvenAndOddSubtraction2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

		int sumOdd = 0;
		int sumEven = 0;

		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] % 2 != 0) {
				sumOdd += numbers[i];
			} else {
				sumEven += numbers[i];
			}
		}

		System.out.println(sumEven - sumOdd);
	}
}