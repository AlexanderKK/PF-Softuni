package _08ObjectsAndClasses_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _05Students {
	static class Student {
		private String firstName;
		private String lastName;
		private int age;
		private String city;

		public Student(String firstName, String lastName, int age, String city) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.city = city;
		}

		public String getName() {
			return this.firstName + " " + this.lastName;
		}

		public int getAge() {
			return this.age;
		}

		public String getCity() {
			return this.city;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String command;
		List<Student> listStudents = new ArrayList<>();

		while(!(command = scanner.nextLine()).equals("end")) {
			String[] inputArr = command.split("\\s+");

			Student student = new Student(inputArr[0], inputArr[1], Integer.parseInt(inputArr[2]), inputArr[3]);
			listStudents.add(student);
		}

		String city = scanner.nextLine();
		for (Student student : listStudents) {
			if(city.equals(student.getCity())) {
				System.out.printf("%s is %d years old%n", student.getName(), student.getAge());
			}
		}
	}
}
