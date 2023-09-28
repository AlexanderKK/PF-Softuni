package _10BitwiseOperations;

import java.util.Scanner;

public class _01BinaryDigitsCount {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int decimalNumber = Integer.parseInt(scanner.nextLine());
		int input = Integer.parseInt(scanner.nextLine());

		int counter = 0;
		while(decimalNumber > 0) {
			int leftOver = decimalNumber % 2;
			if(leftOver == input) {
				counter++;
			}
			decimalNumber /= 2;
		}
		System.out.println(counter);

//		StringBuilder result = new StringBuilder();
//		while(decimalNumber > 0) {
//			int digit = decimalNumber % 2;
//			result.append(digit);
//			decimalNumber /= 2;
//		}
//
//		result.reverse();
//		int count = 0;
//		for (int i = 0; i < result.length(); i++) {
//			if(result.charAt(i) == '0' && input == 0) {
//				count++;
//			} else if(result.charAt(i) == '1' && input == 1) {
//				count++;
//			}
//		}
//		System.out.println(count);
	}
}
