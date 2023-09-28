package _06ExamPreparation5;

import java.util.Scanner;

public class _01BonusScoringSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int students = Integer.parseInt(scanner.nextLine());
		int lectures = Integer.parseInt(scanner.nextLine());
		int bonus = Integer.parseInt(scanner.nextLine());

		double maxBonus = 0;
		int highestAttendance = 0;
		for (int i = 0; i < students; i++) {
			int attendance = Integer.parseInt(scanner.nextLine());

			double totalBonus = attendance * 1.0 / lectures * (5 + bonus);
			if(totalBonus > maxBonus) {
				maxBonus = totalBonus;
				highestAttendance = attendance;
			}
		}

		System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
		System.out.printf("The student has attended %d lectures.%n", highestAttendance);
	}
}
