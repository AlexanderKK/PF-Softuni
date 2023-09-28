package _08ObjectsAndClasses_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _04Students {
	public static class Student {
		private String firstName;
		private String secondName;
		private double grade;

		public Student(String firstName, String secondName, double grade) {
			this.firstName = firstName;
			this.secondName = secondName;
			this.grade = grade;
		}

		public String getFirstName() {
			return this.firstName;
		}

		public String getSecondName() {
			return this.secondName;
		}

		public double getGrade() {
			return this.grade;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Student> students = new ArrayList<>();

		int studentCount = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= studentCount; i++) {
			String[] input = scanner.nextLine().split(" ");

			Student student = new Student(input[0], input[1], Double.parseDouble(input[2]));
			students.add(student);
		}

		for (int i = 0; i < students.size(); i++) {
			for (int j = i + 1; j < students.size(); j++) {
				//Get grade of current and next student
				double currentGrade = students.get(i).getGrade();
				double nextGrade = students.get(j).getGrade();

				//get current and next student
				Student currentStudent = students.get(i);
				Student nextStudent = students.get(j);

				//if current is less than second, swap them
				if(currentGrade < nextGrade) {
					students.set(i, nextStudent);
					students.set(j, currentStudent);
				}
			}
		}

		for (Student student : students) {
			System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getSecondName(), student.getGrade());
		}
	}
}
