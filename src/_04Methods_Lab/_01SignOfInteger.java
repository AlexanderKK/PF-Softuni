package _04Methods_Lab;

import java.util.Scanner;

public class _01SignOfInteger {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num = Integer.parseInt(scanner.nextLine());
		signOfInt(num);
	}

	public static void signOfInt(int number) {
		if(number > 0) {
			System.out.printf("The number %d is positive.", number);
		} else if(number < 0) {
			System.out.printf("The number %d is negative.", number);
		} else {
			System.out.printf("The number %d is zero.", number);
		}
	}
}
