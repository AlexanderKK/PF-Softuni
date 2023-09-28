package _06ExamPreparation2;

import java.util.Scanner;

public class _01BlackFlag {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int days = Integer.parseInt(scanner.nextLine());
		int dailyPlunder = Integer.parseInt(scanner.nextLine());
		double expectedPlunder = Integer.parseInt(scanner.nextLine());

		double totalPlunder = 0.0;
		for (int day = 1; day <= days; day++) {
			totalPlunder += dailyPlunder;

			if(day % 3 == 0) {
				totalPlunder += dailyPlunder / 2.0;
			}
			if(day % 5 == 0) {
				totalPlunder *= 0.7;
			}
		}

		if(totalPlunder >= expectedPlunder) {
			System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
		} else {
			double percentageCollectedPlunder = totalPlunder / expectedPlunder * 100;
			System.out.printf("Collected only %.2f%% of the plunder.", percentageCollectedPlunder);
		}
	}
}
