package _13ExamPreparation1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02EmojiDetector {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String text = scanner.nextLine();

		boolean isDigitPresent = isDigitExisting(text);
		if(isDigitPresent) {
			//Get cool Threshold
			BigInteger coolThreshold = getCoolThreshold(text);
			System.out.printf("Cool threshold: %s%n", coolThreshold + "");

			String emojiRegex = "(?<separator>:{2}|\\*{2})(?<letters>[A-Z][a-z]{2,})\\1";
			Pattern patternEmojis = Pattern.compile(emojiRegex);

			Matcher matcherEmojis = patternEmojis.matcher(text);

			//Get emoji count & add cool ones to list
			List<String> emojisList = new ArrayList<>();
			int emojisCount = getEmojisCount(coolThreshold, matcherEmojis, emojisList);
			System.out.printf("%d emojis found in the text. ", emojisCount);

			//Print Cool Ones
			printCoolEmojis(emojisList);
		}
	}

	private static void printCoolEmojis(List<String> emojisList) {
		System.out.println("The cool ones are:");
		for (String emoji : emojisList) {
			System.out.println(emoji);
		}
	}

	private static int getEmojisCount(BigInteger coolThreshold, Matcher matcherEmojis, List<String> emojisList) {
		int emojisCount = 0;

		while(matcherEmojis.find()) {
			String word = matcherEmojis.group("letters");
			emojisCount++;

			int sumLetters = 0;
			for (char ch : word.toCharArray()) {
				if(Character.isLetter(ch)) {
					sumLetters += ch;
				}
			}

			if(coolThreshold.compareTo(new BigInteger(String.valueOf(sumLetters))) < 0) {
				emojisList.add(matcherEmojis.group());
			}
		}
		return emojisCount;
	}

	private static BigInteger getCoolThreshold(String text) {
		String digitsRegex = "[0-9]";
		Pattern patternDigits = Pattern.compile(digitsRegex);

		Matcher matcherDigits = patternDigits.matcher(text);

		BigInteger coolThreshold = new BigInteger(String.valueOf(1));
		while(matcherDigits.find()) {
			coolThreshold = coolThreshold.multiply(new BigInteger(matcherDigits.group()));
		}
		return coolThreshold;
	}

	private static boolean isDigitExisting(String text) {
		for (char c : text.toCharArray()) {
			if(Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
}
