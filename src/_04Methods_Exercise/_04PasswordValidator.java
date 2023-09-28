package _04Methods_Exercise;

import java.util.Scanner;

public class _04PasswordValidator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String password = scanner.nextLine();

		boolean isValidLength = isValidLength(password);
		if(!isValidLength) {
			System.out.println("Password must be between 6 and 10 characters");
		}

		boolean isValidContent = isValidContent(password);
		if(!isValidContent) {
			System.out.println("Password must consist only of letters and digits");
		}

		boolean isValidCountDigits = isValidCountDigits(password);
		if(!isValidCountDigits) {
			System.out.println("Password must have at least 2 digits");
		}

		if(isValidLength && isValidContent && isValidCountDigits) {
			System.out.println("Password is valid");
		}
	}

	public static boolean isValidLength(String password) {
		return password.length() >= 6 && password.length() <= 10;
	}

	public static boolean isValidContent(String password) {
		for (char symbol : password.toCharArray()) {
			if(!isLetterOrDigit(symbol)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidCountDigits(String password) {
		int digitCounter = 0;

		for (char symbol : password.toCharArray()) {
			if(isDigit(symbol)) {
				digitCounter++;
			}
		}

		return digitCounter >= 2;
	}

	public static boolean isLetterOrDigit(char ch) {
		return ch >= 48 && ch <= 57 || ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122;
	}

	public static boolean isDigit(char ch) {
		return ch >= 48 && ch <= 57;
	}
}
