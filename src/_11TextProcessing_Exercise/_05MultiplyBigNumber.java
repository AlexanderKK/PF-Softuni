package _11TextProcessing_Exercise;

import java.util.Scanner;

public class _05MultiplyBigNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		int digit0To9 = Integer.parseInt(scanner.nextLine());

		if(input.isEmpty()) {
			input = "0";
		} else {
			while(input.charAt(0) == '0') {
				input = input.substring(1);
			}
		}

		if(digit0To9 == 0) {
			System.out.println(0);
		} else {
			StringBuilder resultSb = new StringBuilder();
			int remainder = 0;

			for (int i = input.length() - 1; i >= 0; i--) {
				if(input.charAt(i) != '-') {
					int currentNumber = Integer.parseInt(String.valueOf(input.charAt(i))) * digit0To9;

					currentNumber += remainder;

					if(currentNumber >= 10) {
						remainder = currentNumber / 10;
						currentNumber %= 10;
					} else {
						remainder = 0;
					}

					resultSb.append(currentNumber);

					if(i == 0 && remainder > 0 || i == 1 && input.contains("-") && remainder > 0) {
						resultSb.append(remainder);
					}
				} else {
					resultSb.append(input.charAt(i));
				}
			}
			System.out.println(resultSb.reverse());
		}
	}
}
