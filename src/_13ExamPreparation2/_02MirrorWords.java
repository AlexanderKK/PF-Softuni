package _13ExamPreparation2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02MirrorWords {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String text = scanner.nextLine();
		String regex = "(?<sep>[@#])(?<firstWord>[A-z]{3,})\\1{2}(?<secondWord>[A-z]{3,})\\1";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		List<String> mirrorWords = new ArrayList<>();

		int occurrences = 0;
		while(matcher.find()) {
			occurrences++;

			String firstWord = matcher.group("firstWord");
			String secondWord = new StringBuilder(matcher.group("secondWord")).reverse().toString();
			if(firstWord.equals(secondWord)) {
				mirrorWords.add(firstWord + " <=> " + matcher.group("secondWord"));
			}
		}

		if(occurrences != 0) {
			System.out.printf("%d word pairs found!%n", occurrences);
		} else {
			System.out.println("No word pairs found!");
		}

		if(mirrorWords.size() != 0) {
			System.out.printf("The mirror words are:%n%s%n", String.join(", ", mirrorWords));
		} else {
			System.out.println("No mirror words!");
		}
	}
}
