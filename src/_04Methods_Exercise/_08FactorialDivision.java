package _04Methods_Exercise;

import java.util.Scanner;

public class _08FactorialDivision {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int first = Integer.parseInt(scanner.nextLine());
		int second = Integer.parseInt(scanner.nextLine());

		double divisionResult = divide(calcFactorial(first), calcFactorial(second));
		System.out.printf("%.2f", divisionResult);
	}

	public static int calcFactorial(int number) {
		int result = 1;
		while(number > 0) {
			result *= number;
			number--;
		}
		return result;
	}

	public static double divide(int first, int second) {
		return 1.0 * first / second;
	}
}
