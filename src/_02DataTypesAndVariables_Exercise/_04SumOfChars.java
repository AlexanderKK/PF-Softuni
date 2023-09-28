package _02DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class _04SumOfChars {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		byte charactersCount = Byte.parseByte(scanner.nextLine());

		boolean isValid = charactersCount >= 1 && charactersCount <= 20;
		if(isValid) {
			int sum = 0;
			for (int i = 0; i < charactersCount; i++) {
				sum += scanner.nextLine().charAt(0);
			}

			System.out.println("The sum equals: " + sum);
		}
	}
}