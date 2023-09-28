package _04Methods_Exercise;

import java.util.Scanner;

public class _03CharactersInRange {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		char first = scanner.nextLine().charAt(0);
		char second = scanner.nextLine().charAt(0);

		printCharsInBetween(first, second);
	}

	public static void printCharsInBetween(char first, char second) {
		if(first < second) {
			for (int i = first + 1; i < second; i++) {
				System.out.print((char)i + " ");
			}
		} else if(first > second) {
			for (int i = second + 1; i < first; i++) {
				System.out.print((char)i + " ");
			}
		}
	}
}
