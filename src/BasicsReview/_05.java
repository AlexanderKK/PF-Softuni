package BasicsReview;

import java.util.Scanner;

public class _05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int kgsFood = Integer.parseInt(scanner.nextLine());

		String command = scanner.nextLine();

		int sumFoodEatenGr = 0;
		while(!command.equals("Adopted")) {
			int portionSize = Integer.parseInt(command);

			sumFoodEatenGr += portionSize;
			command = scanner.nextLine();
		}

		int grsFood = kgsFood * 1000;
		if(grsFood >= sumFoodEatenGr) {
			System.out.printf("Food is enough! Leftovers: %d grams.", grsFood - sumFoodEatenGr);
		} else {
			System.out.printf("Food is not enough. You need %d grams more.", sumFoodEatenGr - grsFood);
		}
	}
}
