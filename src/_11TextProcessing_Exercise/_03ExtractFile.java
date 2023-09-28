package _11TextProcessing_Exercise;

import java.util.Scanner;

public class _03ExtractFile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split("\\\\");
		String file = input[input.length - 1];

		String filename = file.split("\\.")[0];
		String extension = file.split("\\.")[1];

		System.out.printf("File name: %s%n", filename);
		System.out.printf("File extension: %s%n", extension);
	}
}
