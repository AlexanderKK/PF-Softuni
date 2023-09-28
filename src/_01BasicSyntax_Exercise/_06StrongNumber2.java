package _01BasicSyntax_Exercise;

import java.util.Scanner;

public class _06StrongNumber2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num = Integer.parseInt(scanner.nextLine());

		int sumFact = 0;
		String number = "" + num;
		for (int i = 0; i < number.length(); i++) {
			int digit = Integer.parseInt(String.valueOf(number.charAt(i)));

			int fact = 1;
			for (int j = digit; j > 0; j--) {
				fact *= j;
			}
			sumFact += fact;
		}

		if(sumFact == num) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
}
