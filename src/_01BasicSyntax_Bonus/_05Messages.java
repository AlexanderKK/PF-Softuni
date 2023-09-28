package _01BasicSyntax_Bonus;

import java.util.Scanner;

public class _05Messages {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		String result = "";
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(scanner.nextLine());

			//Main Digit
			int mainDigit = number % 10;
			boolean isZero = mainDigit == 0;

			if(!isZero) {
				//Offset
				int offset = (mainDigit - 2) * 3;
				if (mainDigit > 7) {
					offset++;
				}

				//Length of input
				int numberLength = (number + "").length();

				//Letter Index
				int letterIndex = offset + numberLength - 1;

				//Add char to string
				char letter = (char) ('a' + letterIndex);
				result += letter;
			} else {
				result += " ";
			}
		}
		System.out.println(result);
	}
}