package _09AssociativeArrays_Lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _01CountRealNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

		//Using TreeMap because we need elements sorted in ascending order
		TreeMap<Double, Integer> countMap = new TreeMap<>();

		for (double num : numbersArr) {
//			if(!countMap.containsKey(num)) {
//				countMap.put(num, 1);
//			} else {
//				countMap.put(num, countMap.get(num) + 1);
//			}

//			if(!countMap.containsKey(num)) {
//				countMap.put(num, 0);
//			}
//			countMap.put(num, countMap.get(num) + 1);

			countMap.putIfAbsent(num, 0);
			countMap.put(num, countMap.get(num) + 1);
		}

		for (Map.Entry<Double, Integer> entry : countMap.entrySet()) {
			System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
		}
	}
}
