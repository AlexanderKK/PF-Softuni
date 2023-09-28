package _01BasicSyntax_Exercise;

import java.util.Scanner;

public class _06StrongNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = Integer.parseInt(scanner.nextLine());

		int sumFact = 0;
		int temp = number;

		while(temp > 0) {
			int remainder = temp % 10;

			int fact = 1;
			while(remainder != 0) {
				fact *= remainder;
				remainder--;
			}
			sumFact += fact;
			temp /= 10;
		}

		if(sumFact == number) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
}