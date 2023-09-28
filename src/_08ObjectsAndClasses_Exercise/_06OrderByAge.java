package _08ObjectsAndClasses_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06OrderByAge {
	public static class Person {
		private String name;
		private int id;
		private int age;

		public Person(String name, int id, int age) {
			this.name = name;
			this.id = id;
			this.age = age;
		}

		public String getName() {
			return this.name;
		}

		public int getID() {
			return this.id;
		}

		public int getAge() {
			return this.age;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Person> people = new ArrayList<>();

		String command;
		while(!"End".equals(command = scanner.nextLine())) {
			String[] input = command.split(" ");

			Person person = new Person(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]));
			people.add(person);
		}

		sortList(people);

		printList(people);
	}

	private static void printList(List<Person> people) {
		for (Person person : people) {
			System.out.printf("%s with ID: %d is %d years old.%n", person.getName(), person.getID(), person.getAge());
		}
	}

	private static void sortList(List<Person> people) {
		for (int i = 0; i < people.size(); i++) {
			for (int j = i + 1; j < people.size(); j++) {
				//Get age of current and next person
				int currentAge = people.get(i).getAge();
				int nextAge = people.get(j).getAge();

				//get current and next person
				Person currentPerson = people.get(i);
				Person nextPerson = people.get(j);

				//if current age is greater than second, swap them
				if(currentAge > nextAge) {
					people.set(i, nextPerson);
					people.set(j, currentPerson);
				}
			}
		}
	}
}
