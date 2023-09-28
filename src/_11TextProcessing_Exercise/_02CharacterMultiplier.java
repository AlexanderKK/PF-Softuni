package _11TextProcessing_Exercise;

import java.util.Scanner;

public class _02CharacterMultiplier {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split(" ");
		String first = input[0];
		String second = input[1];

		int count = Math.min(first.length(), second.length());

		int sumChars = 0;
		for (int i = 0; i < count; i++) {
			sumChars += first.charAt(i) * second.charAt(i);
		}

		sumChars = getCharsLeft(first, second, sumChars);

		System.out.println(sumChars);
	}

	private static int getCharsLeft(String first, String second, int sumChars) {
		if(first.length() > second.length()) {
			for (int i = second.length(); i < first.length(); i++) {
				sumChars += first.charAt(i);
			}
		} else if(first.length() < second.length()){
			for (int i = first.length(); i < second.length(); i++) {
				sumChars += second.charAt(i);
			}
		}
		return sumChars;
	}
}
