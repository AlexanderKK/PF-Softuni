package BasicsReview;

import java.util.Scanner;

public class _06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int tournamentDays = Integer.parseInt(scanner.nextLine());

		double totalAmount = 0;
		int totalWins = 0;
		int totalLosses = 0;

		for (int i = 1; i <= tournamentDays; i++) {
			String command = scanner.nextLine();

			double amountForDay = 0;
			int winsForDay = 0;
			int lossesForDay = 0;
			while(!command.equals("Finish")) {
				String sport = command;

				String result = scanner.nextLine();
				if(result.equals("win")) {
					winsForDay++;
					amountForDay += 20;
				} else if(result.equals("lose")) {
					lossesForDay++;
				}

				command = scanner.nextLine();
			}

			if(winsForDay > lossesForDay) {
				amountForDay *= 1.1;
			}

			totalAmount += amountForDay;
			totalWins += winsForDay;
			totalLosses += lossesForDay;
		}

		if(totalWins > totalLosses) {
			totalAmount *= 1.2;
			System.out.printf("You won the tournament! Total raised money: %.2f", totalAmount);
		} else {
			System.out.printf("You lost the tournament! Total raised money: %.2f", totalAmount);
		}
	}
}
