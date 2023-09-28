package _06ExamPreparation5;

import java.util.Scanner;

public class _02MuOnline {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split("\\|");

		boolean isDead = false;
		int bitcoins = 0;
		int health = 100;
		for (int i = 0; i < input.length; i++) {
			String room = input[i];
			String cmd = room.split(" ")[0];
			int number = Integer.parseInt(room.split(" ")[1]);

			if(cmd.equals("potion")) {
				health = increaseHealth(health, number);
			} else if(cmd.equals("chest")) {
				bitcoins = addBitcoins(bitcoins, number);
			} else {
				health -= number;

				if(health > 0) {
					System.out.printf("You slayed %s.%n", cmd);
				} else {
					System.out.printf("You died! Killed by %s.%n", cmd);
					System.out.printf("Best room: %d%n", i + 1);
					isDead = true;
					break;
				}
			}
		}

		if(!isDead) {
			System.out.println("You've made it!");
			System.out.printf("Bitcoins: %d%n", bitcoins);
			System.out.printf("Health: %d%n", health);
		}
	}

	private static int addBitcoins(int bitcoins, int number) {
		bitcoins += number;
		System.out.printf("You found %d bitcoins.%n", number);
		return bitcoins;
	}

	private static int increaseHealth(int health, int number) {
		health += number;

		if(health > 100) {
			int rest = health - 100;
			number -= rest;
			health = 100;
		}

		System.out.printf("You healed for %d hp.%n", number);
		System.out.printf("Current health: %d hp.%n", health);
		return health;
	}
}
