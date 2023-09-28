package _01BasicSyntax_Exercise;

import java.util.Scanner;

public class _07VendingMachine {
	static double totalCoins = 0;
	static double coins = 0;

	public static void calcCoins(double coins, String product) {
		if(totalCoins >= coins) {
			totalCoins -= coins;
			System.out.printf("Purchased %s%n", product);
		} else {
			System.out.println("Sorry, not enough money");
		}
	}

	public static void calcProduct(String product) {
		if(product.equals("Nuts")) {
			calcCoins(2, "Nuts");
		} else if(product.equals("Water")) {
			calcCoins(0.7, "Water");
		} else if(product.equals("Crisps")) {
			calcCoins(1.5, "Crisps");
		} else if(product.equals("Soda")) {
			calcCoins(0.8, "Soda");
		} else if(product.equals("Coke")) {
			calcCoins(1, "Coke");
		} else {
			System.out.println("Invalid product");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String command = scanner.nextLine();
		while(!command.equals("Start")) {
			coins = Double.parseDouble(command);
			if(coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
				totalCoins += coins;
			} else {
				System.out.printf("Cannot accept %.2f%n", coins);
			}
			command = scanner.nextLine();
		}

		command = scanner.nextLine();
		while(!command.equals("End")) {
			String product = command;
			calcProduct(product);

			command = scanner.nextLine();
		}

		System.out.printf("Change: %.2f", totalCoins);
	}
}