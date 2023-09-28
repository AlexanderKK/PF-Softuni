package _03Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _02PrintNumbersInReverseOrder2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		int[] numbers = new int[n];   //4 bytes * array size
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(scanner.nextLine());
		}

		String result = "";
		for (int i = 0; i < numbers.length; i++) {
			result += (numbers[numbers.length - 1 - i] + " ");
		}
		System.out.println(result.trim());
	}
}
