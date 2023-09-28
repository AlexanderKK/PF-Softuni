package _11TextProcessing_Lab;

import java.util.Scanner;

public class _04TextFilter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split(", ");

		String text = scanner.nextLine();
		for (String word : input) {
			if(text.contains(word)) {
				text = text.replace(word, "*".repeat(word.length()));
			}
		}
		System.out.println(text);
	}
}
