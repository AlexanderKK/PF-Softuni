package _11TextProcessing_Exercise;

import java.util.Scanner;

public class _07StringExplosion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		StringBuilder inputSb = new StringBuilder(scanner.nextLine());

		if(isValid(inputSb)) {
			int addToCount = 0;
			for (int i = 0; i < inputSb.length() - 1; i++) {
				if(inputSb.charAt(i) == '>' && Character.isDigit(inputSb.charAt(i + 1))) {
					int deleteCount = Integer.parseInt(String.valueOf(inputSb.charAt(i + 1)));
					deleteCount += addToCount;

					addToCount = deleteChars(inputSb, addToCount, i, deleteCount);
				}
			}
			System.out.println(inputSb);
		}
	}

	private static int deleteChars(StringBuilder inputSb, int addToCount, int i, int deleteCount) {
		for (int j = 1; j <= deleteCount; j++) {
			if(i < inputSb.length() - 1 && inputSb.charAt(i + 1) != '>') {
				inputSb.deleteCharAt(i + 1);
				addToCount = 0;
			} else {
				addToCount++;
				break;
			}
		}
		return addToCount;
	}

	private static boolean isValid(StringBuilder input) {
		for (char c : input.toString().toCharArray()) {
			if(!Character.isLetterOrDigit(c) && c != '>') {
				return false;
			}
		}
		return true;
	}
}
