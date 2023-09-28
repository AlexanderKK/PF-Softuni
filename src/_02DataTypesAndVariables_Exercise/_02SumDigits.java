package _02DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class _02SumDigits {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int integer = Integer.parseInt(scanner.nextLine());

		int sum = 0;
//		while(integer > 0) {
//			sum += (integer % 10);
//			integer /= 10;
//		}

		for (int i = integer; i > 0 ; i /= 10) {
			sum += i % 10;
		}
		System.out.println(sum);
	}
}