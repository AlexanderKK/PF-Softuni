package _02DataTypesAndVariables_Bonus;

import java.util.Scanner;

public class _01DataTypeFinder2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		while(!input.equals("END")) {
			if(input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
				System.out.printf("%s is boolean type%n", input);
			} else {
				try {
					int number = Integer.parseInt(input);
					System.out.printf("%s is integer type%n", input);
				} catch(Exception l) {
					try {
						float number = Float.parseFloat(input);
						System.out.printf("%s is floating point type%n", input);
					} catch(Exception f) {
						if(input.length() == 1) {
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
