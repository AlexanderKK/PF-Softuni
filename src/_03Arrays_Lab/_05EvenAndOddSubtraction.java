package _03Arrays_Lab;

import java.util.*;

public class _05EvenAndOddSubtraction {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

		int sumEven = 0;
		int sumOdd = 0;

		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] % 2 == 0) {
				sumEven += numbers[i];
			} else {
				sumOdd += numbers[i];
			}
		}
		System.out.println(sumEven - sumOdd);
	}
}