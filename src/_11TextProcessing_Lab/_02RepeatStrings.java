package _11TextProcessing_Lab;

import java.util.Scanner;

public class _02RepeatStrings {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split(" ");

		StringBuilder result = repeatString(input);
		System.out.println(result);
	}

	private static StringBuilder repeatString(String[] input) {
		StringBuilder res = new StringBuilder();
		for (String word : input) {
			for (int i = 0; i < word.length(); i++) {
				res.append(word);
			}
		}
		return res;
	}
}
