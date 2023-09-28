package BasicsReview;

import java.util.Scanner;

public class _04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int days = Integer.parseInt(scanner.nextLine());
		double startingFood = Double.parseDouble(scanner.nextLine());

		double totalBiscuits = 0;
		double sumFood = 0;
		double sumDogFood = 0;
		double sumCatFood = 0;

		for (int i = 1; i <= days; i++) {
			int dogFood = Integer.parseInt(scanner.nextLine());
			int catFood = Integer.parseInt(scanner.nextLine());

			int foodPerDay = dogFood + catFood;
			if(i % 3 == 0) {
				totalBiscuits += foodPerDay * .1;
			}
			sumFood += foodPerDay;
			sumDogFood += dogFood;
			sumCatFood += catFood;
		}

		System.out.printf("Total eaten biscuits: %.0fgr.%n", totalBiscuits);
		System.out.printf("%.2f%% of the food has been eaten.%n", sumFood / startingFood * 100);
		System.out.printf("%.2f%% eaten from the dog.%n", sumDogFood / sumFood * 100);
		System.out.printf("%.2f%% eaten from the cat.%n", sumCatFood / sumFood * 100);
	}
}
