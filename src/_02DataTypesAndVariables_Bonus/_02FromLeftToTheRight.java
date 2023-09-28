package _02DataTypesAndVariables_Bonus;

import java.math.BigDecimal;
import java.util.Scanner;

public class _02FromLeftToTheRight {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		for (int i = 1; i <= n; i++) {
			long firstNum = scanner.nextLong();
			long secondNum = scanner.nextLong();

			long sum = 0;
			if (firstNum >= secondNum) {
				firstNum = Math.abs(firstNum);
				while (firstNum > 0) {
					long digit = firstNum % 10;
					sum += digit;

					firstNum /= 10;
				}
			} else {
				secondNum = Math.abs(secondNum);
				while (secondNum > 0) {
					long digit = secondNum % 10;
					sum += digit;

					secondNum /= 10;
				}
			}
			System.out.println(sum);
		}
	}
}