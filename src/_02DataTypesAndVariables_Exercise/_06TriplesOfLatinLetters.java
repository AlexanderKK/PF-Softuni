package _02DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class _06TriplesOfLatinLetters {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		byte characterLimit = Byte.parseByte(scanner.nextLine());
		for (int i = 0; i < characterLimit; i++) {
			for (int j = 0; j < characterLimit; j++) {
				for (int k = 0; k < characterLimit; k++) {
					char first = (char)('a' + i);
					char second = (char)('a' + j);
					char third = (char)('a' + k);

					System.out.printf("%c%c%c%n", first, second, third);
				}
			}
		}
	}
}