package _03Arrays_Bonus;

import java.util.Arrays;
import java.util.Scanner;

public class _02PascalTriangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		if(n >= 1 && n <= 60) {
			int[] tempArr = new int[0];

			for (int i = 0; i < n; i++) {
				if(i == 0) {
					System.out.println(1);
				} else {
					int[] numbers = new int[i + 1];
					numbers[0] = 1;
					numbers[numbers.length - 1] = 1;

					for (int j = 0; j < numbers.length; j++) {
						if(j > 0 && j < numbers.length - 1) {
							numbers[j] = tempArr[j - 1] + tempArr[j];
						}

						System.out.print(numbers[j]);
						if(j != numbers.length - 1) {
							System.out.print(" ");
						}
					}
					tempArr = Arrays.copyOf(numbers, numbers.length);
					System.out.println();
				}
			}
		}
	}
}
