package _01BasicSyntax_Lab;

import java.util.Scanner;

public class _09SumOfOddNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		if(n >= 1 && n <= 100) {
			int sum = 0;
			int number = 1;
			for (int i = 1; i <= n; i++) {
				System.out.println(number);
				sum += number;
				number += 2;
			}
			System.out.println("Sum: " + sum);
		}
	}
}