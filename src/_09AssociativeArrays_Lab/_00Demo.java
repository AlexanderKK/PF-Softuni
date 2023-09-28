package _09AssociativeArrays_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _00Demo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		HashMap<String, Integer> airplanesMap = new HashMap<>();

		//1 Add, Remove, Contains
		airplanesMap.put("Boeing 737", 130);
		airplanesMap.put("Airbus A320", 265);
		airplanesMap.put("Boeing 737", 30);

		airplanesMap.remove("Boeing 737");

		if(!airplanesMap.containsKey("Boeing 737")) {
			System.out.println("No");
		}

		if(airplanesMap.containsValue(265)) {
			System.out.println("Yes");
		}


		//2 Iterate through the Map
		HashMap<String, Double> fruitsMap = new HashMap<>();

		fruitsMap.put("apple", 1.60);
		fruitsMap.put("banana", 3.80);

		//Loop through a collection entrySet -> collection of entries(key - value) inside map
		for (Map.Entry<String, Double> entry : fruitsMap.entrySet()) {
			String currentKey = entry.getKey();
			double currentValue = entry.getValue();

			System.out.printf("%s - %f%n", currentKey, currentValue);
		}

		//3 Stream API
		int min = Arrays.stream(new int[] {15, 2, 50}).min().orElse(0);

		System.out.println(min);

		int sum = Arrays.stream(new int[] {10, 20, 30}).sum();

		System.out.println(sum);

		double avg = Arrays.stream(new int[] {10, 20, 30}).average().getAsDouble();

		System.out.println(avg);

		String[] wordsArr = {"a", "b", "c", "d", "e"};
		wordsArr = Arrays.stream(wordsArr)
				.map(w -> w + "y").toArray(String[]::new);
		System.out.println(String.join(" ", wordsArr));
	}
}
