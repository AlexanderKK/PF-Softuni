package _04Methods_Exercise;

import java.util.Scanner;

public class _09PalindromeIntegers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String command;
		while(!"END".equals(command = scanner.nextLine())) {
			int number = Integer.parseInt(command);
			System.out.println(isPalindrome2(number));
		}
	}

	public static boolean isPalindrome(int number) {
		String numberStr = number + "";

		String firstHalf = "";
		String secondHalf = "";
		for (int i = 0; i < numberStr.length(); i++) {
			if(i < numberStr.length() / 2) {
				firstHalf += numberStr.charAt(i);
			} else if(numberStr.length() % 2 != 0 && i > numberStr.length() / 2) {
				secondHalf += numberStr.charAt(i);
			} else if(numberStr.length() % 2 == 0 && i >= numberStr.length() / 2 ) {
				secondHalf += numberStr.charAt(i);
			}
		}
		secondHalf = new StringBuilder(secondHalf).reverse().toString();
		return firstHalf.equals(secondHalf);
	}

	public static boolean isPalindrome2(int number) {
		int num = number;
		String numberReversed = "";

		while(number > 0) {
			numberReversed += number % 10;
			number /= 10;
		}

		int numberReversedInt = Integer.parseInt(numberReversed);
		if(num == numberReversedInt) {
			return true;
		}
		return false;
	}
}
