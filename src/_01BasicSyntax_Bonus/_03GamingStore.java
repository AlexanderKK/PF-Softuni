package _01BasicSyntax_Bonus;

import java.util.Scanner;

public class _03GamingStore {
	static double totalSpent = 0;
	static double balance = 0;

	static void calcGame(String game, double price) {
		if(balance >= price) {
			balance -= price;
			totalSpent += price;
			System.out.println("Bought " + game);
		} else {
			System.out.println("Too Expensive");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		balance = Double.parseDouble(scanner.nextLine());
		boolean noMoreMoney = false;

		String command = scanner.nextLine();
		while(!command.equals("Game Time")) {
			String game = command;
			if(game.equals("OutFall 4")) {
				calcGame("OutFall 4", 39.99);
			} else if(game.equals("CS: OG")) {
				calcGame("CS: OG", 15.99);
			} else if(game.equals("Zplinter Zell")) {
				calcGame("Zplinter Zell", 19.99);
			} else if(game.equals("Honored 2")) {
				calcGame("Honored 2", 59.99);
			} else if(game.equals("RoverWatch")) {
				calcGame("RoverWatch", 29.99);
			} else if(game.equals("RoverWatch Origins Edition")) {
				calcGame("RoverWatch Origins Edition", 39.99);
			} else {
				System.out.println("Not Found");
			}

			if(balance <= 0) {
				System.out.println("Out of money!");
				noMoreMoney = true;
				break;
			}

			command = scanner.nextLine();
		}

		if(!noMoreMoney) {
			System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, balance);
		}
	}
}