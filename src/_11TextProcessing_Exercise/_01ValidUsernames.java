package _11TextProcessing_Exercise;

import java.util.Scanner;

public class _01ValidUsernames {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split(", ");
		for (String word : input) {
			boolean isValidUsername = isValid(word);
			if(isValidUsername) {
				System.out.println(word);
			}
		}
	}

	public static boolean isValid(String username) {
		boolean isValidLength = username.length() >= 3 && username.length() <= 16;

		for (char ch : username.toCharArray()) {
			if(!Character.isLetterOrDigit(ch) && ch != '-' && ch != '_') {
				return false;
			}
		}

		return isValidLength;
	}
}
