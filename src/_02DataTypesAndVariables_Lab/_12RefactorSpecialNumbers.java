package _02DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _12RefactorSpecialNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int limit = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= limit; i++) {
			int sum = 0;
			int currentNumber = i;
			while (currentNumber > 0) {
				sum += (currentNumber % 10);
				currentNumber /= 10;
			}

			boolean isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
			if(isSpecial) {
				System.out.printf("%d -> True%n", i);
			} else {
				System.out.printf("%d -> False%n", i);
			}
		}
	}
}