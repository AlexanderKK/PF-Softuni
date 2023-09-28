package BasicsReview;

import java.util.Scanner;

public class _02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int minutesWalkingPerDay = Integer.parseInt(scanner.nextLine());
		int walksCountPerDay = Integer.parseInt(scanner.nextLine());
		int caloriesIntakePerDay = Integer.parseInt(scanner.nextLine());

		int caloriesBurned = minutesWalkingPerDay * 5 * walksCountPerDay;
		if(caloriesBurned > caloriesIntakePerDay / 2.0) {
			System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", caloriesBurned);
		} else {
			System.out.printf( "No, the walk for your cat is not enough. Burned calories per day: %d.", caloriesBurned);
		}
	}
}