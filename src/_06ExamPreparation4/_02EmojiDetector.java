package _06ExamPreparation4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02EmojiDetector {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		int coolThreshold = 1;
		boolean isDigitPresent = false;
		for (char c : input.toCharArray()) {
			if(Character.isDigit(c)) {
				isDigitPresent = true;
				coolThreshold *= Integer.parseInt(String.valueOf(c));
			}
		}

		if(!isDigitPresent) {
			coolThreshold = 0;
		}

		String[] inputArr = input.split("[ .,]+");

		int countEmojis = 0;
		List<String> validCoolEmojis = new ArrayList<>();

		for (String element : inputArr) {
			if(element.startsWith("::") && element.endsWith("::") || element.startsWith("**") && element.endsWith("**")) {
				String elementContent = element.substring(2, element.length() - 2);
				if(elementContent.length() >= 3 && Character.isUpperCase(elementContent.charAt(0))) {
					char[] charArray = elementContent.toCharArray();
					boolean isValidEmoji = true;

					for (int i = 0; i < charArray.length; i++) {
						if(i > 0) {
							if(!Character.isLowerCase(charArray[i])) {
								isValidEmoji = false;
								break;
							}
						}
					}

					if(isValidEmoji) {
						countEmojis++;

						int sumASCIIValues = 0;
						for (int i = 0; i < elementContent.length(); i++) {
							sumASCIIValues += elementContent.charAt(i);
						}

						if(sumASCIIValues > coolThreshold) {
							validCoolEmojis.add(element);
						}
					}
				}
			}
		}

		System.out.printf("Cool threshold: %d%n", coolThreshold);
		System.out.printf("%d emojis found in the text. The cool ones are:%n", countEmojis);
		for (String validCoolEmoji : validCoolEmojis) {
			System.out.println(validCoolEmoji);
		}
	}
}
