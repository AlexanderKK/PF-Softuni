package _09AssociativeArrays_Exercise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _01CountCharsInAString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] chars = Arrays.stream(scanner.nextLine().split("")).filter(ch -> !ch.isBlank()).toArray(String[]::new);

		LinkedHashMap<String, Integer> charsCountMap = new LinkedHashMap<>();
		for (String ch : chars) {
//			if(!charsCountMap.containsKey(ch)) {
//				charsCountMap.put(ch, 1);
//			} else {
//				charsCountMap.put(ch, charsCountMap.get(ch) + 1);
//			}
			charsCountMap.putIfAbsent(ch, 0);
			charsCountMap.put(ch, 1);
		}

		for (Map.Entry<String, Integer> entry : charsCountMap.entrySet()) {
			System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
		}
	}
}
