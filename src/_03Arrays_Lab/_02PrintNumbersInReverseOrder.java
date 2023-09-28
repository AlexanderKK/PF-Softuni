package _03Arrays_Lab;

import java.util.Scanner;

public class _02PrintNumbersInReverseOrder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		int[] numbers = new int[n];

		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(scanner.nextLine());
		}

		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[numbers.length - 1 - i] + " ");
		}
	}
}