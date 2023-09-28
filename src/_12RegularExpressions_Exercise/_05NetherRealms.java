package _12RegularExpressions_Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _05NetherRealms {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split("\\s*,\\s*");

		String health = "[^,\\d+\\-*/.]";

		Pattern ptnHP = Pattern.compile(health);

		String dmg = "[+-]?\\d+\\.?\\d*";
		Pattern ptnDMG = Pattern.compile(dmg);

		String multiplyCount = "\\*";
		Pattern ptnMtp = Pattern.compile(multiplyCount);

		String divideCount = "/";
		Pattern ptnDiv = Pattern.compile(divideCount);

		for (String line : input) {
			if(line.length() > 0 && !line.contains(" ") && !line.contains(",")) {
				int sumHealth = 0;

				Matcher matcherHP = ptnHP.matcher(line);
				while(matcherHP.find()) {
					sumHealth += matcherHP.group().charAt(0);
				}

				double sumDMG = 0.0;
				Matcher matcherDMG = ptnDMG.matcher(line);
				while(matcherDMG.find()) {
					sumDMG += Double.parseDouble(matcherDMG.group());
				}

				Matcher matcherMtp = ptnMtp.matcher(line);
				while(matcherMtp.find()) {
					sumDMG *= 2;
				}

				Matcher matcherDiv = ptnDiv.matcher(line);
				while(matcherDiv.find()) {
					sumDMG /= 2;
				}
				System.out.printf("%s - %d health, %.2f damage%n", line, sumHealth, sumDMG);
			}
		}
	}
}
