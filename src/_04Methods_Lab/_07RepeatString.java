package _04Methods_Lab;

import java.util.Scanner;

public class _07RepeatString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String text = scanner.nextLine();
		int times = Integer.parseInt(scanner.nextLine());

		String repeatedStr = repeatText(text, times);
		System.out.println(repeatedStr);
	}

	public static String repeatText(String str, int times) {
		String repeatedStr = "";
		for (int i = 1; i <= times; i++) {
			repeatedStr += str;
		}
		return repeatedStr;
	}
}
