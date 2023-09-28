package _01BasicSyntax_Exercise;

import java.util.Scanner;

public class _03Vacation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int people = Integer.parseInt(scanner.nextLine());
		String groupType = scanner.nextLine();
		String dayOfWeek = scanner.nextLine();

		double price = 0;
		if(groupType.equals("Students")) {
			if(dayOfWeek.equals("Friday")) {
				price = 8.45 * people;
			} else if(dayOfWeek.equals("Saturday")) {
				price = 9.8 * people;
			} else if(dayOfWeek.equals("Sunday")) {
				price = 10.46 * people;
			}

			if(people >= 30) {
				price *= .85;
			}
		} else if(groupType.equals("Business")) {
			if(dayOfWeek.equals("Friday")) {
				price = 10.9 * people;

				if(people >= 100) {
					price -= 10 * 10.9;
				}
			} else if(dayOfWeek.equals("Saturday")) {
				price = 15.6 * people;

				if(people >= 100) {
					price -= 10 * 15.6;
				}
			} else if(dayOfWeek.equals("Sunday")) {
				price = 16 * people;

				if(people >= 100) {
					price -= 10 * 16;
				}
			}
		} else if(groupType.equals("Regular")) {
			if(dayOfWeek.equals("Friday")) {
				price = 15 * people;
			} else if(dayOfWeek.equals("Saturday")) {
				price = 20 * people;
			} else if(dayOfWeek.equals("Sunday")) {
				price = 22.5 * people;
			}

			if(people >= 10 && people <= 20) {
				price *= .95;
			}
		}
		System.out.printf("Total price: %.2f", price);
	}
}