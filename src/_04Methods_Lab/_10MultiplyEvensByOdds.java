package _04Methods_Lab;

import java.util.Scanner;

public class _10MultiplyEvensByOdds {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = Math.abs(Integer.parseInt(scanner.nextLine()));
		System.out.println(getMultipleOfEvensAndOdds(number));
	}

	public static int getMultipleOfEvensAndOdds(int num) {
		int sumEven = getSumOfEvenDigits(num);
		int sumOdd = getSumOfOddDigits(num);

		return sumEven * sumOdd;
	}

	public static int getSumOfEvenDigits(int num) {
		int result = 0;

		while(num > 0) {
			int digit = num % 10;
			if(digit % 2 == 0) {
				result += digit;
			}

			num /= 10;
		}

		return result;
	}

	public static int getSumOfOddDigits(int num) {
		int result = 0;

		while(num > 0) {
			int digit = num % 10;
			if(digit % 2 != 0) {
				result += digit;
			}

			num /= 10;
		}

		return result;
	}
}
