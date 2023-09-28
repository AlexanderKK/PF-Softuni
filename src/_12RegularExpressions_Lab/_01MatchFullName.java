package _12RegularExpressions_Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01MatchFullName {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String text = scanner.nextLine();

		String regex = "\\b(?<firstname>[A-Z][a-z]+) (?<lastname>[A-Z][a-z]+)\\b";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		while(matcher.find()) {
			System.out.printf("%s ", matcher.group());
		}
	}
}
