package _12RegularExpressions_Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04StarEnigma {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Pattern patternCountLetters = Pattern.compile("[STARstar]");
		String regex = "@(?<planetName>[A-Z][a-z]+)[^@:!\\->]*:(?<population>\\d+)[^@:!\\->]*!(?<attackType>[A|D])![^@:!\\->]*->(?<soldierCount>\\d+)";
		Pattern patternDecrypt = Pattern.compile(regex);

		int attackedPlanetsCount = 0;
		int destroyedPlanetsCount = 0;

		List<String> attackedPlanets = new ArrayList<>();
		List<String> destroyedPlanets = new ArrayList<>();

		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= n; i++) {
			StringBuilder msg = new StringBuilder(scanner.nextLine());

			Matcher matcherCount = patternCountLetters.matcher(msg);
			int lettersCount = 0;

			while(matcherCount.find()) {
				lettersCount++;
			}

			for (int j = 0; j < msg.length(); j++) {
				msg.replace(j, j + 1, String.valueOf( (char) (msg.charAt(j) - lettersCount) ));
			}

			Matcher decryptedMsg = patternDecrypt.matcher(msg);
			while(decryptedMsg.find()) {
				if(decryptedMsg.group("attackType").equals("A")) {
					attackedPlanetsCount++;
					attackedPlanets.add(decryptedMsg.group("planetName"));
				} else if(decryptedMsg.group("attackType").equals("D")) {
					destroyedPlanetsCount++;
					destroyedPlanets.add(decryptedMsg.group("planetName"));
				}
			}
		}

		Collections.sort(attackedPlanets);
		System.out.printf("Attacked planets: %d%n", attackedPlanetsCount);
		for (String planet : attackedPlanets) {
			System.out.printf("-> %s%n", planet);
		}

		Collections.sort(destroyedPlanets);
		System.out.printf("Destroyed planets: %d%n", destroyedPlanetsCount);
		for (String planet : destroyedPlanets) {
			System.out.printf("-> %s%n", planet);
		}
	}
}
