package _07MidExam;

import java.util.Scanner;

public class _01ExperienceGaining {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double neededXp = Double.parseDouble(scanner.nextLine());
		int countBattles = Integer.parseInt(scanner.nextLine());

		double totalXp = 0;
		boolean hasCollectedXp = false;
		for (int i = 1; i <= countBattles; i++) {
			double xpPerBattle = Double.parseDouble(scanner.nextLine());

			if(i % 15 == 0) {
				xpPerBattle *= 1.05;
			} else if(i % 5 == 0) {
				xpPerBattle *= 0.9;
			} else if(i % 3 == 0) {
				xpPerBattle *= 1.15;
			}
			totalXp += xpPerBattle;

			if(totalXp >= neededXp) {
				hasCollectedXp = true;
				System.out.printf("Player successfully collected his needed experience for %d battles.%n", i);
				break;
			}
		}

		if(!hasCollectedXp) {
			System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", neededXp - totalXp);
		}
	}
}
