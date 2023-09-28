package _09AssociativeArrays_Exercise;

import java.util.*;

public class _06StudentAcademy {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedHashMap<String, List<Double>> studentsGradesMap = new LinkedHashMap<>();

		int n = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < n; i++) {
			String name = scanner.nextLine();
			double grade = Double.parseDouble(scanner.nextLine());

			if(!studentsGradesMap.containsKey(name)) {
				studentsGradesMap.put(name, new ArrayList<>());
				studentsGradesMap.get(name).add(grade);
			} else {
				studentsGradesMap.get(name).add(grade);
			}
		}

		for (Map.Entry<String, List<Double>> entry : studentsGradesMap.entrySet()) {
			double sumGrades = 0;

			for (double grade : entry.getValue()) {
				sumGrades += grade;
			}

			double avgGrade = sumGrades / entry.getValue().size();
			if(avgGrade >= 4.50) {
				System.out.printf("%s -> %.2f%n", entry.getKey(), avgGrade);
			}
		}
	}
}
