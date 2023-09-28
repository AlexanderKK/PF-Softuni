package _08ObjectsAndClasses_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06Students2 {
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

		public void setAge(int age) {
			this.age = age;
		}

		public void setCity(String city) {
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

			String name = inputArr[0] + " " + inputArr[1];
			if(isStudentExisting(listStudents, name)) {
				Student student = getExistingStudent(listStudents, name);

				if (student != null) {
					student.setAge(Integer.parseInt(inputArr[2]));
					student.setCity(inputArr[3]);
				}
			} else {
				Student student = new Student(inputArr[0], inputArr[1], Integer.parseInt(inputArr[2]), inputArr[3]);
				listStudents.add(student);
			}
		}

		String city = scanner.nextLine();
		for (Student student : listStudents) {
			if(city.equals(student.getCity())) {
				System.out.printf("%s is %d years old%n", student.getName(), student.getAge());
			}
		}
	}

	private static Student getExistingStudent(List<Student> students, String name) {
		for(Student student : students) {
			if(student.getName().equals(name)) {
				return student;
			}
		}
		return null;
	}

	private static boolean isStudentExisting(List<Student> listStudents, String name) {
		for (Student student : listStudents) {
			if(student.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
