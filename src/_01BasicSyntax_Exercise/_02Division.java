package _01BasicSyntax_Exercise;

import java.util.Scanner;

public class _02Division {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		boolean isNotDivisible = false;
		int divisor = 0;

		if(n % 10 == 0) {
			divisor = 10;
		} else if(n % 7 == 0) {
			divisor = 7;
		} else if(n % 6 == 0) {
			divisor = 6;
		} else if(n % 3 == 0) {
			divisor = 3;
		} else if(n % 2 == 0) {
			divisor = 2;
		} else {
			isNotDivisible = true;
		}

		if(!isNotDivisible) {
			System.out.print("The number is divisible by " + divisor);
		} else {
			System.out.println("Not divisible");
		}
	}
}