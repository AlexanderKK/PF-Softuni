package _02DataTypesAndVariables_Bonus;

import java.util.Scanner;

public class _01DataTypeFinder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		while(!input.equals("END")) {
			if(input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
				boolean bool = Boolean.parseBoolean(input);
				System.out.printf("%s is boolean type%n", input);
			} else {
				try {
					long number = Long.parseLong(input);
					System.out.printf("%s is integer type%n", input);
				} catch (Exception l) {
					try {
						double number = Double.parseDouble(input);
						System.out.printf("%s is floating point type%n", input);
					} catch (Exception f) {
						boolean isChar = input.length() == 1;
						if(isChar) {
							System.out.printf("%s is character type%n", input);
						} else {
							System.out.printf("%s is string type%n", input);
						}
					}
				}
			}

			input = scanner.nextLine();
		}
	}
}