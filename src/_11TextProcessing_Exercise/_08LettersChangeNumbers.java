package _11TextProcessing_Exercise;

import java.util.Scanner;

public class _08LettersChangeNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split("\\s+");
		if(input.length >= 1 && input.length <= 10) {
			double sum = 0.0;
			for (String str : input) {
				String number = getNumberFromStr(str);

				char firstLetter = str.split(number)[0].charAt(0);
				int num = Integer.parseInt(number);
				char secondLetter = str.split(number)[1].charAt(0);

				double result;
				result = calcFirstLetter(firstLetter, num);
				result = calcSecondLetter(secondLetter, result);

				sum += result;
			}

			System.out.printf("%.2f%n", sum);
		}
	}

	private static double calcSecondLetter(char secondLetter, double result) {
		if(Character.isUpperCase(secondLetter)) {
			int secondLetterPos = secondLetter - 64;
			result -= secondLetterPos;
		} else if(Character.isLowerCase(secondLetter)) {
			int secondLetterPos = secondLetter - 96;
			result += secondLetterPos;
		}
		return result;
	}

	private static double calcFirstLetter(char firstLetter, double num) {
		double result = 0.0;
		if(Character.isUpperCase(firstLetter)) {
			int firstLetterPos = firstLetter - 64;
			result = num / firstLetterPos;
		} else if(Character.isLowerCase(firstLetter)) {
			int firstLetterPos = firstLetter - 96;
			result = num * firstLetterPos;
		}
		return result;
	}

	private static String getNumberFromStr(String str) {
		String number = "";
		for (int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				number += str.charAt(i);
			}
		}
		return number;
	}
}
