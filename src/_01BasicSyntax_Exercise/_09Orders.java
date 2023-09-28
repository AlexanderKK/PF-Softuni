package _01BasicSyntax_Exercise;

import java.util.Scanner;

public class _09Orders {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int orders = Integer.parseInt(scanner.nextLine());
		double sumTotal = 0;
		for (int i = 1; i <= orders; i++) {
			double pricePerCapsule = Double.parseDouble(scanner.nextLine());
			int daysInMonth = Integer.parseInt(scanner.nextLine());
			int capsules = Integer.parseInt(scanner.nextLine());

			double total = (daysInMonth * capsules) * pricePerCapsule;
			System.out.printf("The price for the coffee is: $%.2f%n", total);
			sumTotal += total;
		}
		System.out.printf("Total: $%.2f", sumTotal);
	}
}