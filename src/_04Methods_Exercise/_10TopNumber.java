package _04Methods_Exercise;

import java.util.Scanner;

public class _10TopNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		getTopNumbers(n);
	}

	public static void getTopNumbers(int n) {
		for (int number = 1; number <= n; number++) {
			if(isDivisibleBy8(number) && containsOddDigit(number)) {
				System.out.println(number);
			}
		}
	}

	public static boolean isDivisibleBy8(int number) {
		int sum = 0;
		while(number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum % 8 == 0;
	}

	public static boolean containsOddDigit(int number) {
		String numberStr = number + "";
		for (char num : numberStr.toCharArray()) {
			if((int)num % 2 != 0) {
				return true;
			}
		}
		return false;
	}
}
