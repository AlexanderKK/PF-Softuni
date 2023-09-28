package _01BasicSyntax_Lab;

import java.util.Scanner;

public class _10MultiplicationTable {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());

		if(number >= 1 && number <= 100) {
			for (int i = 1; i <= 10; i++) {
				System.out.printf("%d X %d = %d%n", number, i, number * i);
			}
		}
	}
}