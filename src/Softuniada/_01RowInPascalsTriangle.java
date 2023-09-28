package Softuniada;

import java.util.Arrays;
import java.util.Scanner;

public class _01RowInPascalsTriangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		if(n >= 1 && n <= 60) {
			int[] tempArr = new int[0];

			for (int i = 0; i < n + 1; i++) {
				int[] numbers = new int[i + 1];
				numbers[0] = 1;
				numbers[numbers.length - 1] = 1;

				for (int j = 0; j < numbers.length; j++) {
					if(j > 0 && j < numbers.length - 1) {
						numbers[j] = tempArr[j - 1] + tempArr[j];
					}

					if(i == n) {
						System.out.print(numbers[j] + " ");
					}
				}
				tempArr = Arrays.copyOf(numbers, numbers.length);
			}
		}
	}
}
