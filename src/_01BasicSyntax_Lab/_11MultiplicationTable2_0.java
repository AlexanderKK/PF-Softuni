package _01BasicSyntax_Lab;

import java.util.Scanner;

public class _11MultiplicationTable2_0 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		int times = Integer.parseInt(scanner.nextLine());

		if(number >= 1 && number <= 100) {
			do {
				System.out.printf("%d X %d = %d%n", number, times, number * times);
				times++;
			} while (times <= 10);
		}
	}
}