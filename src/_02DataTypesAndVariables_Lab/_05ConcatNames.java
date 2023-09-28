package _02DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _05ConcatNames {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String firstName = scanner.nextLine();
		String surName = scanner.nextLine();
		String delimiter = scanner.nextLine();

		String concatName = String.format("%s%s%s", firstName, delimiter, surName);
		System.out.println(concatName);
	}
}