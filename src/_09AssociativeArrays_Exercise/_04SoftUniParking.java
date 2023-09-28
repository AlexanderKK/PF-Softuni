package _09AssociativeArrays_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04SoftUniParking {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		LinkedHashMap<String, String> platesMap = new LinkedHashMap<>();
		for (int i = 1; i <= n; i++) {
			String input = scanner.nextLine();

			String cmd = input.split(" ")[0];
			String username = input.split(" ")[1];

			if(cmd.equals("register")) {
				String plateNumber = input.split(" ")[2];

				if(!platesMap.containsKey(username)) {
					platesMap.put(username, plateNumber);
					System.out.printf("%s registered %s successfully%n", username, plateNumber);
				} else {
					System.out.printf("ERROR: already registered with plate number %s%n", platesMap.get(username));
				}
			} else if(cmd.equals("unregister")) {
				if(!platesMap.containsKey(username)) {
					System.out.printf("ERROR: user %s not found%n", username);
				} else {
					platesMap.remove(username);
					System.out.printf("%s unregistered successfully%n", username);
				}
			}
		}

		platesMap.forEach((key, value) -> System.out.printf("%s => %s%n", key, value));
	}
}
