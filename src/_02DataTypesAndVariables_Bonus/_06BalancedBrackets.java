package _02DataTypesAndVariables_Bonus;

import java.util.Scanner;

public class _06BalancedBrackets {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		byte lines = Byte.parseByte(scanner.nextLine());

		int openingBrackets = 0;
		int closingBrackets = 0;
		boolean notBalanced = false;
		String lastOpening = "";
		String lastClosing = "";

		for (int i = 0; i < lines; i++) {
			String text = scanner.nextLine();
			if(text.length() >= 1 && text.length() <= 100) {
				if(text.equals("(")) {
					openingBrackets++;

					if(lastOpening.equals(text)) {
						notBalanced = true;
					}
					lastOpening = text;
					lastClosing = "";
				} else if(text.equals(")")) {
					closingBrackets++;

					if(lastClosing.equals(text)) {
						notBalanced = true;
					}
					lastClosing = text;
					lastOpening = "";
				}
			}
		}

		if(notBalanced || openingBrackets != closingBrackets) {
			System.out.println("UNBALANCED");
		} else {
			System.out.println("BALANCED");
		}
	}
}