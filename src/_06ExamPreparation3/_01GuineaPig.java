package _06ExamPreparation3;

import java.util.Scanner;

public class _01GuineaPig {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double kgsFood = Double.parseDouble(scanner.nextLine());
		double kgsHay = Double.parseDouble(scanner.nextLine());
		double kgsCover = Double.parseDouble(scanner.nextLine());
		double guineaWeightKgs = Double.parseDouble(scanner.nextLine());

		double grFood = kgsFood * 1000;
		double grHay = kgsHay * 1000;
		double grCover = kgsCover * 1000;
		double guineaWeightGrs = guineaWeightKgs * 1000;
		boolean isNotEnough = false;

		for (int i = 1; i <= 30; i++) {
			//Give 300 grams of food
			grFood -= 300;

			if(i % 2 == 0) {
				//Give hay - 5% of the rest of the food
				grHay -= grFood * 0.05;
			}

			if(i % 3 == 0) {
				//Give cover - 1/3 of the guinea weight in grams
				grCover -= guineaWeightGrs / 3;
			}

			//If food or hay or cover is finished -> end the loop
			if(grFood <= 0 || grHay <= 0 || grCover <= 0) {
				isNotEnough = true;
				break;
			}
		}

		if(isNotEnough) {
			System.out.println("Merry must go to the pet store!");
		} else {
			double foodKgs = grFood / 1000;
			double hayKgs = grHay / 1000;
			double coverKgs = grCover / 1000;
			System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.%n", foodKgs, hayKgs, coverKgs);
		}
	}
}
