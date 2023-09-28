package _09AssociativeArrays_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _02AMinerTask {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String command;

		LinkedHashMap<String, Integer> resourcesMap = new LinkedHashMap<>();
		while(!"stop".equals(command = scanner.nextLine())) {
			String resource = command;
			int quantity = Integer.parseInt(scanner.nextLine());
			
			resourcesMap.putIfAbsent(resource, 0);
			resourcesMap.put(resource, resourcesMap.get(resource) + quantity);
		}

		for (Map.Entry<String, Integer> entry : resourcesMap.entrySet()) {
			System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
		}
	}
}
