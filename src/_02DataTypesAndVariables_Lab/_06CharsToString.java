package _02DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _06CharsToString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String result = "";
		for (int i = 0; i < 3; i++) {
			result += scanner.nextLine().charAt(0);
		}
		System.out.println(result);
	}
}