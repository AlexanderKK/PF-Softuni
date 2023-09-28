package _09AssociativeArrays_Exercise;

import java.util.*;

public class _10SoftUniExamResults {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String command;
		LinkedHashMap<String, List<Integer>> studentPointsMap = new LinkedHashMap<>();
		LinkedHashMap<String, Integer> submissionsMap = new LinkedHashMap<>();

		while(!"exam finished".equals(command = scanner.nextLine())) {
			if(command.endsWith("banned")) {
				String bannedUser = command.split("-")[0];
				studentPointsMap.remove(bannedUser);
			} else {
				String username = command.split("-")[0];
				String language = command.split("-")[1];
				int points = Integer.parseInt(command.split("-")[2]);

				if(points >= 0 && points <= 100) {
					//Add user if not present and points
					studentPointsMap.putIfAbsent(username, new ArrayList<>());
					studentPointsMap.get(username).add(points);

					//Add language if not present
					submissionsMap.putIfAbsent(language, 0);

					//Add submissions count for existing language or newly created one
					submissionsMap.put(language, submissionsMap.get(language) + 1);
				}
			}
		}

		System.out.println("Results:");
		studentPointsMap.forEach((key, value) -> System.out.printf("%s | %d%n", key, Collections.max(value)));

		System.out.println("Submissions:");
		submissionsMap.entrySet().forEach(entry -> {
			System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
		});
	}
}
