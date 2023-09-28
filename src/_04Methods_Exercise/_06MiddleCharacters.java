package _04Methods_Exercise;

import java.util.Scanner;

public class _06MiddleCharacters {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		System.out.println(getMiddleCharacters(input));
	}

	public static String getMiddleCharacters(String text) {
		String result = "";
		if(text.length() % 2 != 0) {
			result += text.charAt(text.length() / 2);
		} else {
			result += String.format("%s%s",text.charAt(text.length() / 2 - 1), text.charAt(text.length() / 2));
		}
		return result;
	}
}
