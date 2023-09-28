package _12RegularExpressions_Exercise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _02Race {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<String> racers = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

		String regexNames = "(?<name>[A-Za-z]+)";
		Pattern patternNames = Pattern.compile(regexNames);

		String regexDigits = "(?<digit>\\d)";
		Pattern patternDigits = Pattern.compile(regexDigits);

		LinkedHashMap<String, Integer> raceMap = new LinkedHashMap<>();

		String line;
		while(!"end of race".equals(line = scanner.nextLine())) {
			Matcher matcherNames = patternNames.matcher(line);
			Matcher matcherDigits = patternDigits.matcher(line);

			int distance = 0;
			while(matcherDigits.find()) {
				distance += Integer.parseInt(matcherDigits.group("digit"));
			}

			String racer = "";
			while(matcherNames.find()) {
				racer += matcherNames.group("name");
			}

			if(racers.contains(racer)) {
				raceMap.putIfAbsent(racer, 0);
				raceMap.put(racer, raceMap.get(racer) + distance);
			}
		}

		System.out.printf("1st place: %s%n", racers.get(0));
		System.out.printf("2nd place: %s%n", racers.get(1));
		System.out.printf("3rd place: %s%n", racers.get(2));
	}
}
