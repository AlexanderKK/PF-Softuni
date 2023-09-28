package _01BasicSyntax_Bonus;

import java.util.Arrays;
import java.util.Scanner;

public class _01SortNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double[] numbers = new double[3];
		for (int i = 0; i < 3; i++) {
			double newNum = Double.parseDouble(scanner.nextLine());
			numbers[i] = newNum;
		}

		double[] sortedNumbers = new double[3];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if(numbers[i] < numbers[j]) {
					double temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}

			sortedNumbers[i] = numbers[i];
		}
		for (double number : sortedNumbers) {
			System.out.printf("%.0f%n", number);
		}
	}
}