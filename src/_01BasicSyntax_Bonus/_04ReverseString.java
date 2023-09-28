package _01BasicSyntax_Bonus;

import java.util.Scanner;

public class _04ReverseString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String text = scanner.nextLine();
		String reversedText = "";
		for (int i = text.length() - 1; i >= 0; i--) {
			reversedText += text.charAt(i);
		}
		System.out.println(reversedText);
	}
}