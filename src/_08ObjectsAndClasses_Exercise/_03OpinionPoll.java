package _08ObjectsAndClasses_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03OpinionPoll {
	static class Person {
		private String name;
		private int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return this.name;
		}

		public int getAge() {
			return this.age;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Person> people = new ArrayList<>();
		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= n; i++) {
			String[] input = scanner.nextLine().split(" ");

			people.add(new Person(input[0], Integer.parseInt(input[1])));
		}

		for (Person person : people) {
			if(person.getAge() > 30) {
				System.out.println(person.getName() + " - " + person.getAge());
			}
		}
	}
}
