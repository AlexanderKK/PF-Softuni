package _04Methods_Exercise;

import java.util.Scanner;

public class _02VowelsCount {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		int result = getVowelsCount(input);
		System.out.println(result);
	}

	public static int getVowelsCount(String text) {
		String[] vowels = {"a", "e", "o", "i", "u",};
		int vowelsCount = 0;

		for (String vowel : vowels) {
			if (text.contains(vowel)) {
				vowelsCount++;
			}
		}

		return vowelsCount;
	}
}
