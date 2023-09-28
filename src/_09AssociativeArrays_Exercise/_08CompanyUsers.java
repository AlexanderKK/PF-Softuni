package _09AssociativeArrays_Exercise;

import java.util.*;

public class _08CompanyUsers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		LinkedHashMap<String, List<String>> companiesMap = new LinkedHashMap<>();
		String command;
		while(!"End".equals(command = scanner.nextLine())) {
			String company = command.split(" -> ")[0];
			String employeeID = command.split(" -> ")[1];

			companiesMap.putIfAbsent(company, new ArrayList<>());
			if(!companiesMap.get(company).contains(employeeID)) {
				companiesMap.get(company).add(employeeID);
			}
		}

		for (Map.Entry<String, List<String>> entry : companiesMap.entrySet()) {
			System.out.printf("%s%n", entry.getKey());
			for (String employeeID : entry.getValue()) {
				System.out.printf("-- %s%n", employeeID);
			}
		}
	}
}
