package _02DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _02PoundsToDollars {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		float pounds = Float.parseFloat(scanner.nextLine());
		float dollars = pounds * 1.36f;
		System.out.printf("%.3f", dollars);
	}
}