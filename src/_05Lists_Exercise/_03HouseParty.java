package _05Lists_Exercise;

import java.util.*;

public class _03HouseParty {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int guestsCount = Integer.parseInt(scanner.nextLine());

		List<String> guests = new ArrayList<>();
		for (int i = 1; i <= guestsCount; i++) {
			String command = scanner.nextLine();
			String person = command.split(" ")[0];

			if(command.endsWith(" is going!")) {
				if(guests.contains(person)) {
					System.out.printf("%s is already in the list!%n", person);
				} else {
					guests.add(person);
				}
			} else if(command.endsWith(" is not going!")) {
				if(guests.contains(person)) {
					guests.remove(person);
				} else {
					System.out.printf("%s is not in the list!%n", person);
				}
			}
		}

		for (String guest : guests) {
			System.out.println(guest);
		}
	}
}
