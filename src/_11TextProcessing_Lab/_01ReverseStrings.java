package _11TextProcessing_Lab;

import java.util.Scanner;

public class _01ReverseStrings {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String command;
		while(!(command = scanner.nextLine()).equals("end")) {
			String wordReversed = "";

			for (int i = 0; i < command.length(); i++) {
				wordReversed += command.charAt(command.length() - 1 - i);
			}
			System.out.println(command + " = " + wordReversed);
		}
	}
}
