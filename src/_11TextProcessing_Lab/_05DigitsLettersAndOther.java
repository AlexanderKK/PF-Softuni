package _11TextProcessing_Lab;

import java.util.Scanner;

public class _05DigitsLettersAndOther {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String text = scanner.nextLine();

		StringBuilder digitSb = new StringBuilder();
		StringBuilder letterSb = new StringBuilder();
		StringBuilder otherSb = new StringBuilder();

		for (int i = 0; i < text.length(); i++) {
			char token = text.charAt(i);

			if(Character.isDigit(token)) {
				digitSb.append(token);
			} else if(Character.isLetter(token)) {
				letterSb.append(token);
			} else {
				otherSb.append(token);
			}
		}
		System.out.println(digitSb);
		System.out.println(letterSb);
		System.out.println(otherSb);
	}
}
