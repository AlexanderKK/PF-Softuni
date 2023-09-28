package _03Arrays_Lab;

import java.util.Scanner;

public class _04ReverseArrayOfStrings2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		String[] strArray = input.split(" ");

		for (int i = 0; i < strArray.length / 2; i++) {
			String firstStr = strArray[i];
			strArray[i] = strArray[strArray.length - i - 1];
			strArray[strArray.length - i - 1] = firstStr;
		}
		System.out.println(String.join(" ", strArray));
	}
}
