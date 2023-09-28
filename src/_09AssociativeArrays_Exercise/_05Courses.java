package _09AssociativeArrays_Exercise;

import java.util.*;

public class _05Courses {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedHashMap<String, List<String>> coursesMap = new LinkedHashMap<>();

		String command;
		while(!"end".equals(command = scanner.nextLine())) {
			String course = command.split(" : ")[0];
			String name = command.split(" : ")[1];

			coursesMap.putIfAbsent(course, new ArrayList<>());
			coursesMap.get(course).add(name);
		}

		for (Map.Entry<String, List<String>> entry : coursesMap.entrySet()) {
			//Get course
			System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());

			//Get students for course
			for (String name : entry.getValue()) {
				System.out.printf("-- %s%n", name);
			}
		}
	}
}
