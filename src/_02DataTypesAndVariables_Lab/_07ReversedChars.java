package _02DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _07ReversedChars {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		char firstToken = scanner.nextLine().charAt(0);
		char secondToken = scanner.nextLine().charAt(0);
		char thirdToken = scanner.nextLine().charAt(0);

		System.out.printf("%c %c %c", thirdToken, secondToken, firstToken);
	}
}