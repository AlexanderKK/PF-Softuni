package _09AssociativeArrays_Lab;

import java.util.*;

public class _02WordSynonyms {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		LinkedHashMap<String, ArrayList<String>> wordsMap = new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			String word = scanner.nextLine();
			String synonym = scanner.nextLine();

			if(!wordsMap.containsKey(word)) {
				wordsMap.put(word, new ArrayList<>());
			}

			//Access the List(get it by key word) and add synonym
			wordsMap.get(word).add(synonym);
		}

		for (Map.Entry<String, ArrayList<String>> entry : wordsMap.entrySet()) {
			System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
		}
	}
}
