package _12RegularExpressions_Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06ExtractEmails {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String regex = "[A-za-z0-9]+[_.-]*[A-za-z0-9]+@[A-za-z-.]+\\.[A-za-z-]+";
		String text = scanner.nextLine();

		Matcher matcher = Pattern.compile(regex).matcher(text);
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
