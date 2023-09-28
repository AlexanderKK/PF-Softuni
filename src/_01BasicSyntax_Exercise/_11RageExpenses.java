package _01BasicSyntax_Exercise;

import java.util.Scanner;

public class _11RageExpenses {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int lostGamesCount = Integer.parseInt(scanner.nextLine());
		double headSetPrice = Double.parseDouble(scanner.nextLine());
		double mousePrice = Double.parseDouble(scanner.nextLine());
		double keyboardPrice = Double.parseDouble(scanner.nextLine());
		double displayPrice = Double.parseDouble(scanner.nextLine());

		int displayTrashes = lostGamesCount / 12;
		int keyboardTrashes = lostGamesCount / 6;
		int mouseTrashes = lostGamesCount / 3;
		int headSetTrashes = lostGamesCount / 2;

		double headSetRage = headSetPrice * headSetTrashes;
		double mouseRage = mousePrice * mouseTrashes;
		double keyboardRage = keyboardPrice * keyboardTrashes;
		double displayRage = displayPrice * displayTrashes;

		double totalRage = headSetRage + mouseRage + keyboardRage + displayRage;
		System.out.printf("Rage expenses: %.2f lv.", totalRage);
	}
}