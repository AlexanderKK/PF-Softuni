package _02DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _01MetersToKilometers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		short meters = Short.parseShort(scanner.nextLine());
		double kilometers = meters / 1000.0;
		System.out.printf("%.2f", kilometers);
	}
}